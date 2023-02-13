package com.example.film.controller;

import com.example.film.model.UnameAlreadyExistException;
import com.example.film.model.User;
import com.example.film.model.UserAlreadyExistException;
import com.example.film.service.SecurityService;
import com.example.film.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class ProfilController {
    private SecurityService securityService;
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setSecurityService(SecurityService securityService) { this.securityService = securityService; }
    @Autowired
    public void setUserService(UserService userService) { this.userService = userService; }

    @GetMapping("/profil")
    public String profil(Model model){
        String userName = securityService.findLoggedInUsername();
        User user = userService.findByUserName(userName);
        model.addAttribute("user", userService.findByUserName(userName));
        model.addAttribute("updateduser", new User());
        return "profile";
    }



    @PostMapping("/profil")
    public String userUpdate(@Valid User updateduser, Model model, BindingResult bindingResult, @RequestParam("jelszoUjra") String password2) throws Throwable {
        if (bindingResult.hasErrors()) {
            throw (Throwable) bindingResult.getAllErrors();
        }
        String userName = securityService.findLoggedInUsername();
        User u = userService.findByUserName(userName);

        if(updateduser.getUserName() == null || updateduser.getEmail() == null || updateduser.getPassword() == null) {
            model.addAttribute("updateErrorMessage", "Minden mező kitöltése kötelező!");
            return profil(model);
        }
        if(!Objects.equals(updateduser.getPassword(), password2)){
            model.addAttribute("updateErrorMessage","Jelszónak egyeznie kell!");
            return profil(model);
        }
        updateduser.setUserId(u.getUserId());
        updateduser.setRoles(u.getRoles());
        try {
            userService.updateUser(updateduser);
        }catch(UserAlreadyExistException e){
            model.addAttribute("updateErrorMessage", "Az email cím foglalt!");
            return profil(model);
        }catch(UnameAlreadyExistException e){
            model.addAttribute("updateErrorMessage", "A felhasználónév foglalt!");
            return profil(model);
        }
        model.addAttribute("updateMessage", "Sikeresen frissítetted a profilt!");
        return "redirect:/logout";
    }

}
