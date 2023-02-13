package com.example.film.service;

import com.example.film.model.ActorFilms;
import com.example.film.model.Film;
import com.example.film.repository.ActorFilmsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class ActorFilmsService {
    private ActorFilmsRepository actorFilmsRepository;
    @Autowired
    public void setActorFilmsRepository(ActorFilmsRepository actorFilmsRepository){this.actorFilmsRepository=actorFilmsRepository;}

    public void addFilm(ActorFilms c)  {
        actorFilmsRepository.save(c);
    }
}
