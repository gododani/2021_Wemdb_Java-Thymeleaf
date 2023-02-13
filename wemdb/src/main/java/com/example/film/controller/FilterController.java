package com.example.film.controller;

import com.example.film.model.Film;
import com.example.film.service.FilmService;
import com.example.film.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
public class FilterController {
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

    @GetMapping("/filter")
    public String filters(Model model, @RequestParam(name="genre", required = true, defaultValue = "none") String genre) {
        if(Objects.equals(genre, "none")) { return "redirect:/"; }
        String[] mufajok =  {"action", "adventure", "animated", "comedy", "drama", "fantasy", "historical",
                "horror", "sci-fi", "thriller", "western", "sport", "short", "romance", "biography",
                "mysteri", "music", "crime", "game", "war", "psychological", "documentary", "family"};
        if (!Arrays.asList(mufajok).contains(genre.trim().toLowerCase())) { return "redirect:/"; }

        List<Film> films = filmService.getFilmByGenres(genre, "film");
        List <Film> series = filmService.getFilmByGenres(genre, "sorozat");

        if((series.size() + films.size()) == 0) {
            model.addAttribute("noData", "Ezzel a feltétellel egy film vagy sorozat sincs a rendszerben. Próbálj más feltétellel keresni.");
        }
        model.addAttribute("films", films);
        model.addAttribute("series", series);
        model.addAttribute("ratings", ratingService);
        return "filter";
    }
}
