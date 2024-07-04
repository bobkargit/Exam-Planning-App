package com.bob.examplanning__.Services;

import com.bob.examplanning__.Models.Enseignant;
import com.bob.examplanning__.Models.Session;
import com.bob.examplanning__.Models.Surveillance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface ISurveillanceService {

    public void addSurveillance(Surveillance surveillance);

    public void updateSurveillance(Surveillance surveillance);

    public List<Surveillance> getAllSurveillances();

    public void deleteSurveillance(Long id);

    public Surveillance getSurveillanceById(Long id);

    public Set<Enseignant> getEnseignantsBySurveillanceId(Long surveillanceId);

    List<Surveillance> findSurveillancesByExamenId(Long examId);


    public List<Surveillance> findSurveillancesByEnseignantIdAndDate(Long enseignantId, LocalDate date);

    public List<Surveillance> findSurveillancesByAdminIdAndDate(Long adminId, LocalDateTime startDate, LocalDateTime endDate);

}
