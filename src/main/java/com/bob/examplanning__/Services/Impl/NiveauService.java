package com.bob.examplanning__.Services.Impl;

import com.bob.examplanning__.Models.Niveau;
import com.bob.examplanning__.Models.User;
import com.bob.examplanning__.Repository.NiveauRepository;
import com.bob.examplanning__.Services.INiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NiveauService implements INiveauService {
    @Autowired
    private NiveauRepository niveauRepository;

    @Override
    public void addNiveau(Niveau niveau) {
      niveauRepository.save(niveau);
    }

    @Override
    public void updateNiveau(Niveau niveau) {
        Niveau existingNiveau = getNiveauById(niveau.getIdNiveau());

        // Si l'utilisateur existe, mettez à jour ses champs avec les nouvelles valeurs
        if(existingNiveau!=null){
            existingNiveau.setTitre(niveau.getTitre());

            // Continuez avec d'autres champs que vous souhaitez mettre à jour

            // Enregistrez les modifications dans la base de données
            niveauRepository.save(existingNiveau);
        } else {
            throw new RuntimeException("Utilisateur introuvable avec l'ID: " + niveau.getIdNiveau());
            // Ou vous pouvez choisir de renvoyer un statut HTTP approprié comme 404 Not Found
            // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur introuvable avec l'ID: " + user.getIdUser());
        }
    }

    @Override
    public List<Niveau> getAllNiveaux() {
        return niveauRepository.findAll();
    }

    @Override
    public void deleteNiveau(Long id) {
        niveauRepository.deleteById(id);
    }

    @Override
    public Niveau getNiveauById(Long id) {

        return niveauRepository.findById(id).orElse(null);
    }
}
