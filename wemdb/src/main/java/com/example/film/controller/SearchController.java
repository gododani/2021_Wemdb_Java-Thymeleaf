package com.example.film.controller;

import com.example.film.model.Film;
import com.example.film.service.FilmService;
import com.example.film.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
public class SearchController {
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

    @GetMapping("/search")
    public String filters(String filmTitle, Model model) {
        if(Objects.equals(filmTitle, "")) { return "redirect:/"; }

        List<Film> films = filmService.getFilmByTitle(filmTitle, "film");
        List<Film> series = filmService.getFilmByTitle(filmTitle, "sorozat");

        if((series.size() + films.size()) == 0) {
            model.addAttribute("noData", "Ilyen címmel egyetlen film vagy sorozat sincs a rendszerben. Próbálj más feltétellel keresni.");
        }
        model.addAttribute("films", films);
        model.addAttribute("series", series);
        model.addAttribute("ratings", ratingService);
        return "search";
    }
}
