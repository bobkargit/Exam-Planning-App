package com.bob.examplanning__.Controller;

import com.bob.examplanning__.Models.*;
import com.bob.examplanning__.Services.Impl.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExamController {
    @Autowired
    private ExamService examService;
    @Autowired
    private SurveillanceService surveillanceService;
    @Autowired
    private SemesterService semesterService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private TypeExamSevice typeExamSevice;
    @Autowired
    private ElementService elementService;
    @Autowired
    private TypeElementService typeElementService;


    @GetMapping("exam/FormExam")
    public String showNewExamenForm(Model model) {
        model.addAttribute("examen", new Examen());
        model.addAttribute("semesters", semesterService.getAllSemester() );
        model.addAttribute("sessions", sessionService.getAllSessions() );
        model.addAttribute("types", typeExamSevice.getAlltypes() );
        model.addAttribute("modules", elementService.getAllElements() );

        return "AjouterExam";
    }

    @PostMapping("exam/AddExam")
    public String saveExamen(@Valid  @ModelAttribute("examen") Examen examen, Model model) {
        if(examen.getDureePrevue().isEmpty() && examen.getDureeReelle().isEmpty()) {
            String module = examen.getNomExamen();
            for (ElementPedago element : elementService.getAllElements()) {
                if (element.getTitre().equals(module)) {
                    if (element.getTypeElement().equals("module")) {
                        examen.setDureePrevue("2 heures");
                        examen.setDureeReelle("2 heures");
                    }
                    else{
                        examen.setDureePrevue("1 h 30 min");
                        examen.setDureeReelle("1 h 30 min");
                    }
                }
            }
        }
        if(examen.getCordinateurExam()==null){
            String module = examen.getNomExamen();
            for (ElementPedago element : elementService.getAllElements()){
                if (element.getTitre().equals(module)){
                    examen.setCordinateurExam(element.getEnseignant());
                }
            }
        }

        examService.addExam(examen);
        List<Examen> examens= examService.getAllExams();
        model.addAttribute("examens",examens);
        return "exams1";
    }

    @GetMapping("exam/Examens")
    public String showUsers(Model model) {
        List<Examen> examens= examService.getAllExams();
        model.addAttribute("examens",examens);
        return "exams1";
        // On retourne le nom de la vue
    }

    @RequestMapping(value = "exam/editExamen/{idExamen}", method = RequestMethod.GET)
    public String updateUserForm(@PathVariable(name = "idExamen") int idExamen, Model model) {
        model.addAttribute("semesters", semesterService.getAllSemester() );
        model.addAttribute("sessions", sessionService.getAllSessions() );
        model.addAttribute("types", typeExamSevice.getAlltypes() );
        model.addAttribute("modules", elementService.getAllElements() );
        model.addAttribute("ExamenModel", examService.getExamById(Long.valueOf(idExamen)));


        return "UpdateExamen";
    }
    @RequestMapping("exam/updateExamenC")
    public String updateUser(@Valid @ModelAttribute("ExamenModel") Examen examen, BindingResult bindingResult,
                             Model model) {

        // Si il y a des erreurs de validation
        if (bindingResult.hasErrors()) {

            return "UpdateExamen";
        }

        // Si il y a pas des erreurs
        examService.updateExam(examen);
        List<Examen> examens= examService.getAllExams();
        model.addAttribute("examens",examens);
        return "exams1";
    }
    @RequestMapping(value = "exam/deleteExamen/{idExamen}", method = RequestMethod.POST)
    public String delete(@PathVariable int idExamen, Model model) {
        examService.deleteExam(Long.valueOf(idExamen));

        // Behind the scenes, RedirectView will trigger a
        // HttpServletResponse.sendRedirect() – which will perform the actual redirect.
        List<Examen> examens= examService.getAllExams();
        model.addAttribute("examens",examens);
        return "exams1";
        //return "redirect:/managePersons";
    }


}
