package com.example.film.controller;

import com.example.film.model.*;
import com.example.film.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;


@Controller
@RequestMapping("/film/")
public class FilmController {
    private FilmService filmService;
    private RatingService ratingService;
    private ReviewService reviewService;
    private UserService userService;
    private SecurityService securityService;
    private ActorFilmsService actorFilmsService;

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
    @Autowired
    public void setUserService(UserService userService) { this.userService = userService; }
    @Autowired
    public void setSecurityService(SecurityService securityService) { this.securityService = securityService; }
    @Autowired
    public void setActorFilmsService(ActorFilmsService actorFilmsService){this.actorFilmsService=actorFilmsService;}


    @GetMapping("/{id}" )
    public String film(Model model, @PathVariable long id){
        Optional<Film> film = filmService.findById(id);
        if(!film.isPresent()) return "redirect:/";
        if(!film.get().getTipus().equals("film")) return "redirect:/";
        String userName = securityService.findLoggedInUsername();

        model.addAttribute("film", film);
        model.addAttribute("actorPartObject", new TempModelForActorFilms());
        model.addAttribute("rating", ratingService);
        model.addAttribute("userRating", new Rating());
        model.addAttribute("kritika", new Review());
        model.addAttribute("reviews", reviewService.getFilmReview(id));
        model.addAttribute("reviewRating", reviewService);
        model.addAttribute("user", userService);
        model.addAttribute("actors",filmService.findActor(id));
        model.addAttribute("actorsList",filmService.actorList());


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(auth instanceof AnonymousAuthenticationToken)) {
            model.addAttribute("authorizeUserReview", reviewService.getByFilmIdAndUserId(id, userService.findByUserName(userName).getUserId()));
            model.addAttribute("authorizeUserRating", ratingService.getRatingByUserIdAndFilmId(userService.findByUserName(userName).getUserId(), id));
        }
        return "film";
    }

    @GetMapping("/")
    public String notFound(){
        return "redirect:/";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, params = "ratingSave")
    @ResponseStatus(value= HttpStatus.OK)
    public String ratingSave(@Valid @ModelAttribute("userRating") Rating rating, Model model, BindingResult bindingResult, @PathVariable long id) throws Throwable {
        if (bindingResult.hasErrors()) {
            throw (Throwable) bindingResult.getAllErrors();
        }
        if(rating.getValue() == 0 || rating.getValue() > 5 || rating.getValue() < 1) {
            model.addAttribute("ratingErrorMessage", "Az értékelésnek 1 és 5 között kell lennie!");
            return film(model, id);
        }
        rating.setFilmId(id);
        String userName = securityService.findLoggedInUsername();
        User user = userService.findByUserName(userName);
        rating.setUserId(user.getUserId());

        if(ratingService.ratingExist(rating.getUserId(), rating.getFilmId())) {
            model.addAttribute("ratingMessage", "Sikeresen módosítottad az értékelést!");
            ratingService.updateRating(rating);
        } else {
            model.addAttribute("ratingMessage", "Sikeresen értékelted a filmet!");
            ratingService.addRating(rating);
        }
        return film(model, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, params = "reviewSave")
    @ResponseStatus(value= HttpStatus.OK)
    public String reviewSave(@Valid @ModelAttribute("kritika") Review kritika, Model model, BindingResult bindingResult, @PathVariable long id) throws Throwable {
        if (bindingResult.hasErrors()) {
            throw (Throwable) bindingResult.getAllErrors();
        }
        String userName = securityService.findLoggedInUsername();
        User user = userService.findByUserName(userName);
        if(reviewService.reviewExist(user.getUserId(), id)) {
            model.addAttribute("reviewErrorMessage", "Már írtál kritikát ehhez a filmhez!");
            return film(model, id);
        }
        if(kritika.getRating() > 5 || kritika.getRating() < 1) {
            model.addAttribute("reviewErrorMessage", "A kritika értékelésének 1 és 5 között kell lennie!");
            return film(model, id);
        }
        if(kritika.getTitle() == null) {
            model.addAttribute("reviewErrorMessage", "Kötelező kitölteni a címet!");
            return film(model, id);
        }
        if(kritika.getContent() == null) {
            model.addAttribute("reviewErrorMessage", "Kötelező kitölteni a kritika mezőt!");
            return film(model, id);
        }

        model.addAttribute("reviewMessage", "A kritikát sikeresen beküldted!");
        kritika.setFilmId(id);
        kritika.setUserId(user.getUserId());
        kritika.setCreateDate(new Date());
        reviewService.addReview(kritika);
        return film(model, id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.POST, params = "reviewUpdate")
    @ResponseStatus(value= HttpStatus.OK)
    public String reviewUpdate(@Valid @ModelAttribute("kritika") Review kritika, Model model, BindingResult bindingResult, @PathVariable long id) throws Throwable {
        if (bindingResult.hasErrors()) {
            throw (Throwable) bindingResult.getAllErrors();
        }
        String userName = securityService.findLoggedInUsername();
        User user = userService.findByUserName(userName);
        if(kritika.getRating() > 5 || kritika.getRating() < 1) {
            model.addAttribute("reviewErrorMessage", "A kritikanak 1 és 5 között kell lennie!");
            return film(model, id);
        }
        if(kritika.getTitle() == null) {
            model.addAttribute("reviewErrorMessage", "Kötelező kitölteni a címet!");
            return film(model, id);
        }
        if(kritika.getContent() == null) {
            model.addAttribute("reviewErrorMessage", "Kötelező kitölteni a kritika mezőt!");
            return film(model, id);
        }
        model.addAttribute("reviewMessage", "A kritikát sikeresen frissítetted!");
        kritika.setFilmId(id);
        kritika.setUserId(user.getUserId());
        kritika.setCreateDate(new Date());
        reviewService.updateReview(kritika);
        return film(model, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, params = "reviewDelete")
    @ResponseStatus(value= HttpStatus.OK)
    public String reviewDelete(@Valid @ModelAttribute("kritika") Review kritika, Model model, BindingResult bindingResult, @PathVariable long id) throws Throwable {
        if (bindingResult.hasErrors()) {
            throw (Throwable) bindingResult.getAllErrors();
        }
        String userName = securityService.findLoggedInUsername();
        User user = userService.findByUserName(userName);
        kritika.setFilmId(id);
        kritika.setUserId(user.getUserId());
        reviewService.delReview(kritika);
        model.addAttribute("reviewMessage", "Sikeresen törölted a kritikát!");
        return film(model, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, params = "ratingDelete")
    @ResponseStatus(value= HttpStatus.OK)
    public String ratingDelete(@Valid @ModelAttribute("userRating") Rating rating, Model model, BindingResult bindingResult, @PathVariable long id) throws Throwable {
        if (bindingResult.hasErrors()) {
            throw (Throwable) bindingResult.getAllErrors();
        }
        String userName = securityService.findLoggedInUsername();
        User user = userService.findByUserName(userName);
        rating.setFilmId(id);
        rating.setUserId(user.getUserId());
        ratingService.delRating(rating);
        model.addAttribute("ratingMessage", "Sikeresen törölted az értékelést!");
        return film(model, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, params = "actorSave")
    @ResponseStatus(value= HttpStatus.OK)
    public String ActorSave(@Valid @ModelAttribute("actorPartObject") TempModelForActorFilms tempModelForActorFilms, Model model, BindingResult bindingResult, @PathVariable long id) throws Throwable {
        if (bindingResult.hasErrors()) {
            throw (Throwable) bindingResult.getAllErrors();
        }

        ActorFilms c = new ActorFilms();
        c.setPart(tempModelForActorFilms.getPartName());
        c.setActorId(tempModelForActorFilms.getActorName());
        c.setFilmId(id);
        actorFilmsService.addFilm(c);
        return film(model, id);
    }


}

