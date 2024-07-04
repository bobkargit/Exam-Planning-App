package com.bob.examplanning__.Services.Impl;

import com.bob.examplanning__.Models.Salle;
import com.bob.examplanning__.Repository.SalleRepository;
import com.bob.examplanning__.Services.ISalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleService implements ISalleService {
    @Autowired
    private SalleRepository salleRepository;
    @Override
    public void addSalle(Salle salle) {
        salleRepository.save(salle);
    }

    @Override
    public void updateSalle(Salle salle) {
       salleRepository.save(salle);
    }

    @Override
    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }

    @Override
    public void deleteSalle(Long id) {
       salleRepository.deleteById(id);
    }

    @Override
    public Salle getSalleById(Long id) {
        return salleRepository.findById(id).orElse(null);
    }
}
