package com.bob.examplanning__.Controller;



import com.bob.examplanning__.Models.*;
import com.bob.examplanning__.Services.Impl.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final AdminService adminService;

    @GetMapping("exam/Showinglogin")
    public String showForm(Model model){


        return "Login";
    }

    @PostMapping("exam/Accueil")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if (adminService.verifyLoginInfo(username, password)) {
            return "users";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "Login"; // Return login page with error message
        }
     /*   if (username.equals("admin@gmail.com") && password.equals("admin") || username.equals("admin2@gmail.com") && password.equals("admin") ) {
            model.addAttribute("message", "Login successful");
            return "Accueil"; // vue après succès de connexion
        } else {
            model.addAttribute("message", "Invalid email or password");
            return "Login"; // vue de connexion avec message d'erreur
        }*/
    }
}
