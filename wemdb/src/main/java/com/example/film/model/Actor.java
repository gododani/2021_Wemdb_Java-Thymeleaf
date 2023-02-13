package com.example.film.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table(name="actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ActorId;
    @NotEmpty(message = "A név nem lehet üres.")
    @Column(name="name",nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "actor_films",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<Film> films;
    public String getName() {
        return name;
    }
}
