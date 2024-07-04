package com.bob.examplanning__.Services.Impl;


import com.bob.examplanning__.Models.User;
import com.bob.examplanning__.Repository.UserRepository;
import com.bob.examplanning__.Services.IUserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private   UserRepository userRepository ;


    public void addUser(User user){
        userRepository.save(user);
    }

    public void updateUser(User user){
        // Vérifiez d'abord si l'utilisateur existe dans la base de données
        User existingUser = getUserById(user.getIdUser());

        // Si l'utilisateur existe, mettez à jour ses champs avec les nouvelles valeurs
        if(existingUser!=null){
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setType(user.getType());
            existingUser.setDepartement(user.getDepartement());
            // Continuez avec d'autres champs que vous souhaitez mettre à jour

            // Enregistrez les modifications dans la base de données
            userRepository.save(existingUser);
        } else {
            throw new RuntimeException("Utilisateur introuvable avec l'ID: " + user.getIdUser());
            // Ou vous pouvez choisir de renvoyer un statut HTTP approprié comme 404 Not Found
            // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur introuvable avec l'ID: " + user.getIdUser());
        }
    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
}
