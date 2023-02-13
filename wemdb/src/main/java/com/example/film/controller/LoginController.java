package com.example.film.controller;

import com.example.film.model.User;
import com.example.film.service.SecurityService;
import com.example.film.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    private UserService userService;
    private SecurityService securityService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/login")
    public String login(Model model, String error, User user){
        if (error != null){
            model.addAttribute("error", "Felhasználónév vagy jelszó hibás!");
        }
        return "login";
    }



}
