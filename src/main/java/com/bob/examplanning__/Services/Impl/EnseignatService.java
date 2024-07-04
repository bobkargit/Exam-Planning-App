package com.bob.examplanning__.Services.Impl;

import com.bob.examplanning__.Models.Admin;
import com.bob.examplanning__.Models.Enseignant;
import com.bob.examplanning__.Models.Filiere;
import com.bob.examplanning__.Models.Personnel;
import com.bob.examplanning__.Repository.EnseignantRepository;
import com.bob.examplanning__.Services.IEnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignatService implements IEnseignantService {
    @Autowired
    EnseignantRepository enseignantRepository;

    @Override
    public void addEnseignant(Enseignant enseignant) {
        enseignantRepository.save(enseignant);
    }

    @Override
    public void updateEnseignant(Enseignant enseignant) {
        Enseignant existinenseignant = getEnseignantById(enseignant.getId());

        // Si l'utilisateur existe, mettez à jour ses champs avec les nouvelles valeurs
        if(existinenseignant!=null){
            existinenseignant.setPrenom(enseignant.getPrenom());
            existinenseignant.setNom(enseignant.getNom());
            existinenseignant.setDepartement(enseignant.getDepartement());
            // Continuez avec d'autres champs que vous souhaitez mettre à jour

            // Enregistrez les modifications dans la base de données
            enseignantRepository.save(existinenseignant);
        } else {
            throw new RuntimeException("Utilisateur introuvable avec l'ID: " + enseignant.getId());
            // Ou vous pouvez choisir de renvoyer un statut HTTP approprié comme 404 Not Found
            // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur introuvable avec l'ID: " + user.getIdUser());
        }
    }

    @Override
    public List<Enseignant> getAllEnseignants() {
       return enseignantRepository.findAll();
    }

    @Override
    public void deleteEnseignant(Long id) {
          enseignantRepository.deleteById(id);
    }

    @Override
    public Enseignant getEnseignantById(Long id) {
        return enseignantRepository.findById(id).orElse(null);
    }
    @Override
    public List<Enseignant> getEnseignantsByDepartementId(Long departementId) {
        return enseignantRepository.findAllByDepartementId(departementId);
    }
}
