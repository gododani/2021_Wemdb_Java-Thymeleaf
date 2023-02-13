package com.example.film.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data

@Entity
@Table(name="writer")
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long writerId;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "written_films",
            joinColumns = @JoinColumn(name = "writer_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<Film> writtenFilm = new ArrayList<>();

    public void writeFilm(Film film) { writtenFilm.add(film); }
}
