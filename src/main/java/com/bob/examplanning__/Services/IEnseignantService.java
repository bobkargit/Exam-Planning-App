package com.bob.examplanning__.Services;

import com.bob.examplanning__.Models.Enseignant;
import com.bob.examplanning__.Models.Filiere;

import java.util.List;

public interface IEnseignantService {
    public void addEnseignant(Enseignant enseignant);

    public void updateEnseignant(Enseignant enseignant);

    public List<Enseignant> getAllEnseignants();

    public void deleteEnseignant(Long id);

    public Enseignant getEnseignantById(Long id);
    public List<Enseignant> getEnseignantsByDepartementId(Long departementId);
}
