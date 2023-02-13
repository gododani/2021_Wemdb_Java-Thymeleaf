package com.example.film.controller;

import com.example.film.service.FilmService;
import com.example.film.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SorozatokController {
    private FilmService filmService;
    private RatingService ratingService;
    @Autowired
    public void setFilmService(FilmService filmService){
        this.filmService=filmService;
    }
    @Autowired
    public void setRatingService(RatingService ratingService){
        this.ratingService=ratingService;
    }

    @GetMapping("/sorozatok")
    public String sorozat(Model model){
        model.addAttribute("films", filmService.getFilms("sorozat"));
        model.addAttribute("ratings", ratingService);

        return "sorozatok";
    }
}
