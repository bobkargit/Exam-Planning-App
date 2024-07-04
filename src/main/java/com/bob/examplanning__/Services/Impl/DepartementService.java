package com.bob.examplanning__.Services.Impl;

import com.bob.examplanning__.Models.Departement;
import com.bob.examplanning__.Repository.DepartementRepository;
import com.bob.examplanning__.Services.IDepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService implements IDepartementService {
    @Autowired
    private DepartementRepository departementRepository;

    @Override
    public void addDepartement(Departement departement) {
        departementRepository.save(departement);
    }

    @Override
    public void updateDepartement(Departement departement) {

    }

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);
    }

    @Override
    public Departement getDepartementById(Long id) {
         return departementRepository.findById(id).orElse(null);
    }

    @Override
    public Long getIdByNomDepartement(String nomDepartement) {
        return departementRepository.findIdByNomDepartement(nomDepartement);
    }
}
