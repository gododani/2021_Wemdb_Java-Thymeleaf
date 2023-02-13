package com.example.film.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="actor_films")
public class ActorFilms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long JoinId;
    private String Part;


    @Column(name = "actor_id")
    private long actorId;
    @Column(name = "film_id")
    private long filmId;


}
