package com.example.film.controller;
import com.example.film.service.FilmService;
import com.example.film.service.RatingService;
import com.example.film.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private FilmService filmService;
    private RatingService ratingService;
    private ReviewService reviewService;

    @Autowired
    public void setFilmService(FilmService filmService){
        this.filmService = filmService;
    }
    @Autowired
    public void setRatingService(RatingService ratingService){
        this.ratingService = ratingService;
    }
    @Autowired
    public void setReviewService(ReviewService reviewService) { this.reviewService = reviewService; }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("films", filmService.getTop10("film"));
        model.addAttribute("series", filmService.getTop10("sorozat"));
        model.addAttribute("rating", ratingService);
        model.addAttribute("reviewRating", reviewService);
        return "fooldal";
    }
}
