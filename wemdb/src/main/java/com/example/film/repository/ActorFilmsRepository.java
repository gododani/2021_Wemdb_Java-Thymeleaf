package com.example.film.repository;

import com.example.film.model.ActorFilms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorFilmsRepository  extends JpaRepository<ActorFilms,Long> {
}
