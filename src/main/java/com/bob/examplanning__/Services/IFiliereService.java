package com.bob.examplanning__.Services;

import com.bob.examplanning__.Models.Filiere;

import java.util.List;

public interface IFiliereService {
    public void addFiliere(Filiere filiere);

    public void updateFiliere(Filiere filiere);

    public List<Filiere> getAllFiliere();

    public void deleteFiliere(Long id);

    public Filiere getFiliereById(Long id);
}
