package com.bob.examplanning__.Services;

import com.bob.examplanning__.Models.Salle;

import java.util.List;

public interface ISalleService {
    public void addSalle(Salle salle);

    public void updateSalle(Salle salle);

    public List<Salle> getAllSalles();

    public void deleteSalle(Long id);

    public Salle getSalleById(Long id);
}
