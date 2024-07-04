package com.bob.examplanning__.Controller;

import com.bob.examplanning__.Models.ElementPedago;
import com.bob.examplanning__.Models.Salle;
import com.bob.examplanning__.Models.User;
import com.bob.examplanning__.Services.IUserService;
import com.bob.examplanning__.Services.Impl.SalleService;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SalleController {
    @Autowired
    public SalleService salleService;

    @GetMapping("exam/Salles")
    public String showUsers(Model model) {
        List<Salle> salles= salleService.getAllSalles();
        model.addAttribute("salles",salles);
        return "salles1";
        // On retourne le nom de la vue
    }
    @GetMapping("exam/ShowFormSalle")
    public String showForm(Model model) {
        model.addAttribute("salle",new Salle());

        return "AjouterSallee";
        // On retourne le nom de la vue
    }

    @PostMapping("exam/addSalle")
    public String process(@Valid @ModelAttribute("element") Salle salle, BindingResult bindingResult,
                          ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "AjouterSallee";
        } else {
            salleService.addSalle(salle);
            model.addAttribute("infoMsg", "Salle ajouté avec succès");
            List<Salle> salles = salleService.getAllSalles();
            model.addAttribute("salles", salles);
            return "salles1";
        }

    }

    @RequestMapping(value = "exam/editSalle/{idSalle}", method = RequestMethod.GET)
    public String updateUserForm(@PathVariable(name = "idSalle") int idSalle, Model model) {

        model.addAttribute("SalleModel", salleService.getSalleById(Long.valueOf(idSalle)));


        return "UpdateSalle";
    }
    @RequestMapping("exam/updateSalleC")
    public String updateUser(@Valid @ModelAttribute("SalleModel") Salle salle, BindingResult bindingResult,
                             Model model) {

        // Si il y a des erreurs de validation
        if (bindingResult.hasErrors()) {

            return "UpdateSalle";
        }

        // Si il y a pas des erreurs
        salleService.updateSalle(salle);
        List<Salle> salles= salleService.getAllSalles();
        model.addAttribute("salles",salles);
        return "salles1";
    }
    @RequestMapping(value = "exam/deleteSalle/{idSalle}", method = RequestMethod.POST)
    public String delete(@PathVariable int idSalle, Model model) {
        salleService.deleteSalle(Long.valueOf(idSalle));

        // Behind the scenes, RedirectView will trigger a
        // HttpServletResponse.sendRedirect() – which will perform the actual redirect.
        List<Salle> salles= salleService.getAllSalles();
        model.addAttribute("salles",salles);
        return "salles1";
        //return "redirect:/managePersons";
    }








}
