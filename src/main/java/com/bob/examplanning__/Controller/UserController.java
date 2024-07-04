package com.bob.examplanning__.Controller;


import com.bob.examplanning__.Models.Admin;
import com.bob.examplanning__.Models.Enseignant;
import com.bob.examplanning__.Models.User;
import com.bob.examplanning__.Services.IAdminService;
import com.bob.examplanning__.Services.IEnseignantService;
import com.bob.examplanning__.Services.IUserService;
import com.bob.examplanning__.Services.Impl.DepartementService;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService userService; // Injection du service metier ici
    @Autowired
    private IAdminService adminService;
    @Autowired
    private IEnseignantService enseignantService;
    @Autowired
    private DepartementService departementService;

    private List<String> l=new ArrayList<String>();

    public UserController(){
        l.add("teacher");
        l.add("admin");
    }

    @GetMapping("exam/Show")
    public String showForm(Model model) {
        model.addAttribute("list",l);
        model.addAttribute("user",new User());
        model.addAttribute("departements",departementService.getAllDepartements());

        return "AjouterSalle";
        // On retourne le nom de la vue
    }
    @PostMapping("exam/addUser")
    public String process(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                          ModelMap model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMsg", "Les données sont invalides.");
        } else {
            userService.addUser(user);
            model.addAttribute("infoMsg", "Personne ajouté avec succès");
            if(user.getType().equals("admin")){
                Admin admin=new Admin();
                admin.setPrenom(user.getFirstName());
                admin.setNom(user.getLastName());
                admin.setEmail(user.getEmail());
                admin.setPassword(user.getPassword());
                adminService.addAdmin(admin);
            }
            else{
                Enseignant enseignant=new Enseignant();
                enseignant.setPrenom(user.getFirstName());
                enseignant.setNom(user.getLastName());
                enseignant.setEmail(user.getEmail());
                enseignant.setPassword(user.getPassword());
                enseignant.setDepartement(user.getDepartement());

                enseignantService.addEnseignant(enseignant);
            }

        }
        List<User> users= userService.getAllUsers();
        model.addAttribute("users",users);

        return "users1";
    }
    @GetMapping("exam/Users")
    public String showUsers(Model model) {
        List<User> users= userService.getAllUsers();
        model.addAttribute("users",users);

        return "users1";
        // On retourne le nom de la vue
    }
    @RequestMapping(value = "exam/editUser/{idUser}", method = RequestMethod.GET)
    public String updateUserForm(@PathVariable(name = "idUser") int idUser, Model model) {

        model.addAttribute("userModel", userService.getUserById(Long.valueOf(idUser)));
        model.addAttribute("departements",departementService.getAllDepartements());


        return "updateUser";
    }
    @RequestMapping("exam/updateUserC")
    public String updateUser(@Valid @ModelAttribute("userModel") User user, BindingResult bindingResult,
                               Model model) {

        // Si il y a des erreurs de validation
        if (bindingResult.hasErrors()) {

            return "updateUser";
        }

        // Si il y a pas des erreurs
        userService.updateUser(user);
        List<User> users= userService.getAllUsers();
        model.addAttribute("users",users);

        // rediriger vers un autre handler
        return "users1";
    }
    @RequestMapping(value = "exam/deleteUser/{idUser}", method = RequestMethod.POST)
    public String delete(@PathVariable int idUser, Model model) {
        userService.deleteUser(Long.valueOf(idUser));

        // Behind the scenes, RedirectView will trigger a
        // HttpServletResponse.sendRedirect() – which will perform the actual redirect.
        List<User> users= userService.getAllUsers();
        model.addAttribute("users",users);
        return "users1";

        //return "redirect:/managePersons";
    }




}
