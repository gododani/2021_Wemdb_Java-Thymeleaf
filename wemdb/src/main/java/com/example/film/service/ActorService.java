package com.example.film.service;

import com.example.film.model.Actor;
import com.example.film.repository.ActorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ActorService {
    private ActorRepository actorRepository;
    @Autowired
    public void setActorRepository(ActorRepository actorRepository){
        this.actorRepository=actorRepository;
    }
    public void addActor(Actor c){
        actorRepository.save(c);
        log.info("Contact added: " + c.toString());
    }




}
