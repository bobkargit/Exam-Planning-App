package com.bob.examplanning__.Repository;

import com.bob.examplanning__.Models.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
    @Query("SELECT d.IdDepartement FROM Departement d WHERE d.nomDepartement = :nom")
    Long findIdByNomDepartement(@Param("nom") String nomDepartement);
}
