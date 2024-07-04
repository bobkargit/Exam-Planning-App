package com.bob.examplanning__.Controller;

import com.bob.examplanning__.Models.*;
import com.bob.examplanning__.Services.Impl.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class SurveillanceController {
    @Autowired
    private SurveillanceService surveillanceService;
    @Autowired
    private SalleService salleService;
    @Autowired
    private EnseignatService enseignatService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ExamService examService;
    @Autowired
    private DepartementService departementService;

    @RequestMapping(value = "exam/FormSurveillance/{idExam}", method = RequestMethod.GET)
    public String updateUserForm(@PathVariable(name = "idExam") Long idExam, Model model) {
        Surveillance surveillance = new Surveillance();
        surveillance.setExamen(examService.getExamById(idExam));
        model.addAttribute("surveillance", surveillance);
        model.addAttribute("enseignants", enseignatService.getAllEnseignants());
        model.addAttribute("salles", salleService.getAllSalles());
        model.addAttribute("admins", adminService.getAllAdmins());
        model.addAttribute("idExammm", idExam);
        model.addAttribute("deparements", departementService.getAllDepartements());

        // Récupérer toutes les surveillances pour l'examen
        List<Surveillance> existingSurveillances = surveillanceService.findSurveillancesByExamenId(idExam);
        // Récupérer les salles déjà utilisées
        List<Salle> usedSalles = existingSurveillances.stream()
                .map(Surveillance::getSalle)
                .collect(Collectors.toList());
        // Filtrer la liste des salles pour exclure celles déjà utilisées
        List<Salle> availableSalles = salleService.getAllSalles().stream()
                .filter(salle -> !usedSalles.contains(salle))
                .collect(Collectors.toList());
        model.addAttribute("salles", availableSalles);

        return "AjouterSurveillance";
    }

    @RequestMapping("exam/AddSurveillance")
    public String updateUser(@Valid @ModelAttribute("surveillance") Surveillance surveillance,
                             @RequestParam("examenId") Long examenId, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "AjouterSurveillance";
        }

        Examen examen = examService.getExamById(examenId);
        surveillance.setExamen(examen);

        List<Surveillance> existingSurveillances = surveillanceService.findSurveillancesByExamenId(examenId);
        List<Enseignant> usedEnseignants = existingSurveillances.stream()
                .flatMap(surv -> surv.getEnseignants().stream())
                .collect(Collectors.toList());
        List<Admin> usedAdmins = existingSurveillances.stream()
                .map(Surveillance::getAdmin)
                .collect(Collectors.toList());

        List<Enseignant> availableEnseignants;
        List<Admin> availableAdmins;

        if (surveillance.getMethodeAffectation().equals("Aleatoirement")) {
            availableEnseignants = enseignatService.getAllEnseignants().stream()
                    .filter(enseignant -> !usedEnseignants.contains(enseignant))
                    .collect(Collectors.toList());
            availableAdmins = adminService.getAllAdmins().stream()
                    .filter(admin -> !usedAdmins.contains(admin))
                    .collect(Collectors.toList());
        } else {
            Long id = departementService.getIdByNomDepartement(surveillance.getMethodeAffectation());
            availableEnseignants = enseignatService.getEnseignantsByDepartementId(id).stream()
                    .filter(enseignant -> !usedEnseignants.contains(enseignant))
                    .collect(Collectors.toList());
            availableAdmins = adminService.getAllAdmins().stream()
                    .filter(admin -> !usedAdmins.contains(admin))
                    .collect(Collectors.toList());
        }

        // Filter out enseignants who are already supervising 2 exams on the same day
        LocalDate examDate = examen.getDateHeureDebut().toLocalDate();
        Map<Enseignant, Long> enseignantExamCount = new HashMap<>();
        Map<Admin, Long> adminExamCount = new HashMap<>();

        for (Enseignant enseignant : availableEnseignants) {
            long count = surveillanceService.findSurveillancesByEnseignantIdAndDate(enseignant.getId(), examDate).stream().count();
            enseignantExamCount.put(enseignant, count);
        }

        availableEnseignants = availableEnseignants.stream()
                .filter(enseignant -> enseignantExamCount.get(enseignant) < 2)
                .collect(Collectors.toList());

        for (Admin admin : availableAdmins) {
            long count = surveillanceService.findSurveillancesByAdminIdAndDate(admin.getId(), examDate.atStartOfDay(), examDate.plusDays(1).atStartOfDay()).size();
            adminExamCount.put(admin, count);
        }

        availableAdmins = availableAdmins.stream()
                .filter(admin -> adminExamCount.get(admin) < 2)
                .collect(Collectors.toList());

        List<Salle> usedSalles = existingSurveillances.stream()
                .map(Surveillance::getSalle)
                .collect(Collectors.toList());
        List<Salle> availableSalles = salleService.getAllSalles().stream()
                .filter(salle -> !usedSalles.contains(salle))
                .collect(Collectors.toList());

        if (availableEnseignants.size() < surveillance.getNbrSurveillants() || availableAdmins.isEmpty() || availableSalles.isEmpty()) {
            model.addAttribute("errorMessage", "Il n'y a pas assez d'enseignants ou d'administrateurs disponibles pour affecter cette surveillance.");
            model.addAttribute("salles", availableSalles);
            model.addAttribute("enseignants", enseignatService.getAllEnseignants());
            model.addAttribute("admins", adminService.getAllAdmins());
            model.addAttribute("idExammm", examenId);
            model.addAttribute("deparements", departementService.getAllDepartements());
            return "AjouterSurveillance";
        }

        int nombreEnseignantsAffectes = surveillance.getNbrSurveillants();
        for (int i = 0; i < nombreEnseignantsAffectes; i++) {
            Enseignant enseignant = availableEnseignants.get(i);
            surveillance.addEnseignant(enseignant);
        }

        Admin admin = availableAdmins.get(0);
        surveillance.setAdmin(admin);

        surveillanceService.addSurveillance(surveillance);

        List<Surveillance> surveillances = surveillanceService.findSurveillancesByExamenId(examenId);
        model.addAttribute("surveillances", surveillances);
        return "SurveillanceByExamId";
    }

    @RequestMapping(value = "exam/ConsulterSurveillance/{idExamen}", method = RequestMethod.GET)
    public String getServaillanceByid(@PathVariable(name = "idExamen") Long idExamen, Model model) {
        List<Surveillance> surveillances = surveillanceService.findSurveillancesByExamenId(idExamen);
        model.addAttribute("surveillances", surveillances);
        return "SurveillanceByExamId";
    }
    /*@RequestMapping(value = "exam/deleteSurveillance/{idSurveillance}", method = RequestMethod.POST)
    public String deleteSurveillance(@PathVariable Long idSurveillance, @RequestParam("examenId") Long examenId, Model model) {
        surveillanceService.deleteSurveillance(idSurveillance);

        List<Surveillance> surveillances = surveillanceService.findSurveillancesByExamenId(examenId);
        model.addAttribute("surveillances", surveillances);
        return "SurveillanceByExamId";
    }*/



}
