package com.bob.examplanning__.Services.Impl;

import com.bob.examplanning__.Models.Examen;
import com.bob.examplanning__.Models.Surveillance;
import com.bob.examplanning__.Models.User;
import com.bob.examplanning__.Repository.ExamRepository;
import com.bob.examplanning__.Services.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService implements IExamService {
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private SurveillanceService surveillanceService;

    @Override
    public void addExam(Examen examen) {
        examRepository.save(examen);
    }

    @Override
    public void updateExam(Examen examen) {
        Examen existingexamen = getExamById(examen.getIdExamen());
        List<Surveillance> surv=surveillanceService.findSurveillancesByExamenId(examen.getIdExamen());
        for(Surveillance s:surv){
            surveillanceService.deleteSurveillance(s.getIdServeillance());
        }

        // Si l'utilisateur existe, mettez à jour ses champs avec les nouvelles valeurs
        if(existingexamen!=null){
            existingexamen.setNomExamen(examen.getNomExamen());
            existingexamen.setDateHeureDebut(examen.getDateHeureDebut());
            existingexamen.setDureePrevue(examen.getDureePrevue());
            existingexamen.setDureeReelle(examen.getDureeReelle());
            existingexamen.setSemester(examen.getSemester());
            existingexamen.setSession(examen.getSession());
            existingexamen.setTypeExam(examen.getTypeExam());
            existingexamen.setEpreuve(examen.getEpreuve());
            existingexamen.setPv(examen.getPv());
            existingexamen.setRapport(examen.getRapport());
            // Continuez avec d'autres champs que vous souhaitez mettre à jour

            // Enregistrez les modifications dans la base de données
            examRepository.save(existingexamen);
        } else {
            throw new RuntimeException("Utilisateur introuvable avec l'ID: " + examen.getIdExamen());
            // Ou vous pouvez choisir de renvoyer un statut HTTP approprié comme 404 Not Found
            // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur introuvable avec l'ID: " + user.getIdUser());
        }
    }

    @Override
    public List<Examen> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }

    @Override
    public Examen getExamById(Long id) {
        return examRepository.findById(id).orElse(null);
    }
}
