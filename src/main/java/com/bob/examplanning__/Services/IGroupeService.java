package com.bob.examplanning__.Services;

import com.bob.examplanning__.Models.Groupe;

import java.util.List;

public interface IGroupeService {
    public void addGroupe(Groupe groupe);

    public void updateGroupe(Groupe groupe);

    public List<Groupe> getAllGroupe();

    public void deleteGroupe(Long id);

    public Groupe getGroupeById(Long id);
}

