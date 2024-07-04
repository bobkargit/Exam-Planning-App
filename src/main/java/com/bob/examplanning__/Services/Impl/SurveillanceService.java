package com.bob.examplanning__.Services.Impl;

import com.bob.examplanning__.Models.Enseignant;
import com.bob.examplanning__.Models.Surveillance;
import com.bob.examplanning__.Repository.ServeillanceRepository;
import com.bob.examplanning__.Services.ISurveillanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Service
public class SurveillanceService implements ISurveillanceService {

    @Autowired
    ServeillanceRepository serveillanceRepository;
    @Override
    public void addSurveillance(Surveillance surveillance) {
        serveillanceRepository.save(surveillance);
    }

    @Override
    public void updateSurveillance(Surveillance surveillance) {

    }

    @Override
    public List<Surveillance> getAllSurveillances() {
        return serveillanceRepository.findAll();
    }

    @Override
    public void deleteSurveillance(Long id) {
        serveillanceRepository.deleteById(id);
    }

    @Override
    public Surveillance getSurveillanceById(Long id) {
        return serveillanceRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Enseignant> getEnseignantsBySurveillanceId(Long surveillanceId) {
        Surveillance surveillance = serveillanceRepository.findById(surveillanceId)
                .orElseThrow(() -> new RuntimeException("Surveillance not found with id " + surveillanceId));
        return surveillance.getEnseignants();
    }
    @Override
    public List<Surveillance> findSurveillancesByExamenId(Long examId) {
        return serveillanceRepository.findByExamenIdExamen(examId);
    }

    @Override
    public List<Surveillance> findSurveillancesByEnseignantIdAndDate(Long enseignantId, LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
        return serveillanceRepository.findSurveillancesByEnseignantIdAndDate(enseignantId, startOfDay, endOfDay);
    }

    @Override
    public List<Surveillance> findSurveillancesByAdminIdAndDate(Long adminId, LocalDateTime startDate, LocalDateTime endDate) {
        return serveillanceRepository.findSurveillancesByAdminIdAndDate(adminId, startDate, endDate);
    }

}
