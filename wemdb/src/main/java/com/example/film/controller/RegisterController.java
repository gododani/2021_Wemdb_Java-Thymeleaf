package com.example.film.controller;

import com.example.film.model.UnameAlreadyExistException;
import com.example.film.model.User;
import com.example.film.model.UserAlreadyExistException;
import com.example.film.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.validation.Valid;
import java.util.Objects;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String register(User user){
        return "register";
    }
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService){
        this.userService=userService;
    }


    @PostMapping("/register")
    public String userRegistration(@Valid User user, BindingResult bindingResult, Model model, @RequestParam("register-pwd-again") String password2)  {
            if (bindingResult.hasErrors()) {
                return "register";
            }
            if(!Objects.equals(user.getPassword(), password2)){
                model.addAttribute("errorPWMessage","Jelszónak egyeznie kell!");
                return "register";
            }
            try{
                userService.addUser(user);

            }catch (UserAlreadyExistException e){
                model.addAttribute("errorMessage","Már van felhasználó ezzel az email címmel!");
                return "register";
            }catch(UnameAlreadyExistException e){
                model.addAttribute("errorMessage", "Már van felhasználó ezzel a felhasználónévvel!");
                return "register";
            }

            model.addAttribute("message", "Sikeres regisztráció");
            return "login";

    }
}
