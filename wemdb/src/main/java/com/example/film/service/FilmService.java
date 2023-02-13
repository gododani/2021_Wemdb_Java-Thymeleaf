package com.example.film.service;

import com.example.film.model.Actor;
import com.example.film.model.Film;

import com.example.film.repository.FilmRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class FilmService {
    private FilmRepository filmRepository;
    @Autowired
    public void setFilmRepository(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> getFilms(String tipus){
        return filmRepository.findAllByTipusEquals(tipus);
    }

    public Optional<Film> findById(Long id) {
        return filmRepository.findById(id);
    }

    public void addFilm(Film c)  {
        String[] genres = c.getMufaj().toLowerCase().split(" ");
        c.setMufaj(Arrays.toString(genres));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i].trim();
            if(!stringBuilder.toString().contains(genre)) {
                stringBuilder.append(genres[i]);
                if(i < genres.length-1) {
                    stringBuilder.append(", ");
                }
            }
        }
        c.setMufaj(stringBuilder.toString());

        filmRepository.save(c);
        log.info("Film added: " + c.toString());
    }

    public List<Film> getTop10(String type) {
        return filmRepository.findTop10(type);
    }

    public List<Film> getUserRatings(long userId) {
        return filmRepository.getUserRatings(userId);
    }

    public Film getFilmByTitleAndType(String cim, String type) {
        return filmRepository.findByCimAndTipus(cim, type);
    }

    public List<Film> getFilmByGenres(String genre, String type) {
        return filmRepository.getFilmByGenres(genre, type);
    }

    public List<Film> getFilmByTitle(String title, String type) {
        return filmRepository.getFilmByTitle(title, type);
    }


    public List<String> findActor(Long id) {return filmRepository.findActor(id); }
   // public  List<String> findPart(Long id) {return filmRepository.findPart(id);}
    public List<String[]> actorList(){ return filmRepository.actorList();}
}
