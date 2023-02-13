package com.example.film.controller;

import com.example.film.model.User;
import com.example.film.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RatingsController {
    private FilmService filmService;
    private RatingService ratingService;
    private UserService userService;
    private SecurityService securityService;

    @Autowired
    public void setFilmService(FilmService filmService){
        this.filmService = filmService;
    }
    @Autowired
    public void setRatingService(RatingService ratingService){
        this.ratingService = ratingService;
    }
    @Autowired
    public void setUserService(UserService userService) { this.userService = userService; }
    @Autowired
    public void setSecurityService(SecurityService securityService) { this.securityService = securityService; }

    @GetMapping("/ratings" )
    public String ratings(Model model){
        String userName = securityService.findLoggedInUsername();
        User user = userService.findByUserName(userName);

        model.addAttribute("films", filmService.getUserRatings(user.getUserId()));
        model.addAttribute("rating", ratingService);
        model.addAttribute("user", user);

        return "ratings";
    }

}
