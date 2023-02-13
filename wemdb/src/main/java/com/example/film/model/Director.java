package com.example.film.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data

@Entity
@Table(name="director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long directorId;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "directed_films",
            joinColumns = @JoinColumn(name = "director_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<Film> directedFilm = new ArrayList<>();

    public void directedFilm(Film film) { directedFilm.add(film); }
}
