package com.bob.examplanning__.Repository;

import com.bob.examplanning__.Models.Surveillance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ServeillanceRepository extends JpaRepository<Surveillance, Long> {

    List<Surveillance> findByExamenIdExamen(Long examId);
    @Query("SELECT s FROM Surveillance s JOIN s.enseignants e WHERE e.id = :enseignantId AND s.examen.dateHeureDebut BETWEEN :startOfDay AND :endOfDay")
    List<Surveillance> findSurveillancesByEnseignantIdAndDate(
            @Param("enseignantId") Long enseignantId,
            @Param("startOfDay") LocalDateTime startOfDay,
            @Param("endOfDay") LocalDateTime endOfDay
    );

    @Query("SELECT s FROM Surveillance s WHERE s.admin.id = :adminId AND s.examen.dateHeureDebut BETWEEN :startDate AND :endDate")
    List<Surveillance> findSurveillancesByAdminIdAndDate(@Param("adminId") Long adminId, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
