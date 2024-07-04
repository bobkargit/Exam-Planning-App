package com.bob.examplanning__.Services.Impl;

import com.bob.examplanning__.Models.ElementPedago;
import com.bob.examplanning__.Models.User;
import com.bob.examplanning__.Repository.ElementRepository;
import com.bob.examplanning__.Services.IElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ElementService implements IElementService {

    @Autowired
    private ElementRepository elementRepository;
    public void addElement(ElementPedago elementPedago){
        elementRepository.save(elementPedago);
    }

    public void updateElement(ElementPedago elementPedago){
        ElementPedago existingelement = getElementById(elementPedago.getIdElement());

        // Si l'utilisateur existe, mettez à jour ses champs avec les nouvelles valeurs
        if(existingelement!=null){
            existingelement.setTitre(elementPedago.getTitre());
            existingelement.setNiveau(elementPedago.getNiveau());
            existingelement.setTypeElement(elementPedago.getTypeElement());
            existingelement.setCoordinateur(elementPedago.getCoordinateur());
            existingelement.setEnseignant(elementPedago.getEnseignant());
            // Continuez avec d'autres champs que vous souhaitez mettre à jour

            // Enregistrez les modifications dans la base de données
            elementRepository.save(existingelement);
        } else {
            throw new RuntimeException("Utilisateur introuvable avec l'ID: " + elementPedago.getIdElement());
            // Ou vous pouvez choisir de renvoyer un statut HTTP approprié comme 404 Not Found
            // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur introuvable avec l'ID: " + user.getIdUser());
        }
    }

    public List<ElementPedago> getAllElements(){
        return elementRepository.findAll();
    }

    public void deleteElement(Long id){
        elementRepository.deleteById(id);
    }

    public ElementPedago getElementById(Long id){
        return elementRepository.findById(id).orElse(null);
    }
}
