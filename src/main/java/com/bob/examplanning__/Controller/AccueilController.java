package com.bob.examplanning__.Controller;


import com.bob.examplanning__.Models.ElementPedago;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {

    /*@GetMapping("/AccueilShow")
    public String showForm() {

        return "Accueil";
    }*/
   @GetMapping("exam/Accueil1")
    public String showForm2() {

        return "Accueil";
    }

}
