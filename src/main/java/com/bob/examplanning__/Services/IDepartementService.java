package com.bob.examplanning__.Services;

import com.bob.examplanning__.Models.Departement;

import java.util.List;

public interface IDepartementService {
    public void addDepartement(Departement departement);

    public void updateDepartement(Departement departement);

    public List<Departement> getAllDepartements();

    public void deleteDepartement(Long id);

    public Departement getDepartementById(Long id);

    public Long getIdByNomDepartement(String nomDepartement) ;
}

