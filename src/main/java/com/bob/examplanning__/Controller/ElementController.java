package com.bob.examplanning__.Controller;


import com.bob.examplanning__.Models.*;
import com.bob.examplanning__.Services.Impl.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ElementController {
    @Autowired
    ElementService elementService;
    @Autowired
    private NiveauService niveauService;

    @Autowired
    private TypeElementService typeElementService;

    @Autowired
    private EnseignatService enseignantService;


    @GetMapping("exam/ShowFormElement")
    public String showForm(Model model) {
        model.addAttribute("element", new ElementPedago());
        model.addAttribute("niveaux", niveauService.getAllNiveaux());
        model.addAttribute("typesElement", typeElementService.getAlltypes());
        model.addAttribute("enseignants", enseignantService.getAllEnseignants());

        return "AjouterElement";
        // On retourne le nom de la vue
    }

    @PostMapping("exam/addElement")
    public String process(@Valid @ModelAttribute("element") ElementPedago elementPedago, BindingResult bindingResult,
                          ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("niveaux", niveauService.getAllNiveaux());
            model.addAttribute("typesElement", typeElementService.getAlltypes());
            model.addAttribute("enseignants", enseignantService.getAllEnseignants());
            return "AjouterElement";
        } else {
            elementService.addElement(elementPedago);
            model.addAttribute("infoMsg", "Element ajouté avec succès");
            List<ElementPedago> elements =elementService.getAllElements();
            model.addAttribute("elements", elements);
            return "elements1";
        }

    }
    @GetMapping("exam/Elements")
    public String showUsers(Model model) {
        List<ElementPedago> elements= elementService.getAllElements();
        model.addAttribute("elements",elements);
        return "elements1";
        // On retourne le nom de la vue
    }

    @RequestMapping(value = "exam/editElement/{idElement}", method = RequestMethod.GET)
    public String updateUserForm(@PathVariable(name = "idElement") int idElement, Model model) {
        model.addAttribute("niveaux", niveauService.getAllNiveaux());
        model.addAttribute("typesElement", typeElementService.getAlltypes());
        model.addAttribute("enseignants", enseignantService.getAllEnseignants());
        model.addAttribute("elementModel", elementService.getElementById(Long.valueOf(idElement)));


        return "updateElement";
    }
    @RequestMapping("exam/updateElementC")
    public String updateUser(@Valid @ModelAttribute("elementModel") ElementPedago element, BindingResult bindingResult,
                             Model model) {

        // Si il y a des erreurs de validation
        if (bindingResult.hasErrors()) {

            return "updateElement";
        }

        // Si il y a pas des erreurs
        elementService.updateElement(element);
        List<ElementPedago> elements= elementService.getAllElements();
        model.addAttribute("elements",elements);

        // rediriger vers un autre handler
        return "elements1";
    }
    @RequestMapping(value = "exam/deleteElement/{idElement}", method = RequestMethod.POST)
    public String delete(@PathVariable int idElement, Model model) {
        elementService.deleteElement(Long.valueOf(idElement));

        // Behind the scenes, RedirectView will trigger a
        // HttpServletResponse.sendRedirect() – which will perform the actual redirect.
        List<ElementPedago> elements= elementService.getAllElements();
        model.addAttribute("elements",elements);
        return "elements1";

        //return "redirect:/managePersons";
    }
}
