package com.example.film.controller;

import com.example.film.model.Film;
import com.example.film.service.FilmService;
import com.example.film.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
@RequestMapping("/film")
public class FilmAddController {
    @GetMapping("/add")
    public String register(Film film){
        return "filmAdd";
    }
    private FilmService filmService;
    private ReviewService reviewService;
    @Autowired
    public void setFilmService(FilmService filmService){
        this.filmService = filmService;
    }
    @Autowired
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/add")
    public String filmRegistration(@Valid Film film, BindingResult bindingResult, Model model)  {
        if(filmService.getFilmByTitleAndType(film.getCim(), film.getTipus()) != null) {
            model.addAttribute("filmAlreadyExist", "Már létezik ilyen című " + film.getTipus() + "!");
            return "filmAdd";
        }
        String[] mufajok =  {"action", "adventure", "animated", "comedy", "drama", "fantasy", "historical",
                            "horror", "sci-fi", "thriller", "western", "sport", "short", "romance", "biography",
                            "mysteri", "music", "crime", "game", "war", "psychological", "documentary", "family"};
        String[] genres = film.getMufaj().split(" ");
        for (String genre : genres) {
            if (!Arrays.asList(mufajok).contains(genre.trim().toLowerCase())) {
                model.addAttribute("filmGenresError", "Hibas típus: " + genre + "!  A kategóriákat írásjelek és számok nélkül szóközzel elválasztva add meg!");
                return "filmAdd";
            }
        }
        if (bindingResult.hasErrors()) {
            if(film.getPremier()==null){
                model.addAttribute("premierErrorMessage", "Nem lehet nulla!");
                return "filmAdd";
            }
            if(!(("film".equals(film.getTipus())) || ("sorozat".equals(film.getTipus())))) {
                model.addAttribute("filmTypeError", "Filmnek vagy sorozatnak kell lennie!");
                return "filmAdd";
            }
            return "filmAdd";
        }
        filmService.addFilm(film);
        model.addAttribute("message", "Sikeres hozzadas");
        return "filmAdd";
    }
}
