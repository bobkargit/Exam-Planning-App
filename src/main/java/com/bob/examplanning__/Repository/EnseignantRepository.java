package com.bob.examplanning__.Repository;

import com.bob.examplanning__.Models.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
    @Query("SELECT e FROM Enseignant e WHERE e.departement.IdDepartement = :departementId")
    List<Enseignant> findAllByDepartementId(@Param("departementId") Long departementId);
}
