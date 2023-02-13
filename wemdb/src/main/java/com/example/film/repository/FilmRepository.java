package com.example.film.repository;

import com.example.film.model.Actor;
import com.example.film.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {
    Optional<Film> findById(Long id);

    List<Film> findAllByTipusEquals(String tipus);

    Film findByCimAndTipus(String cim, String tipus);

    @Query(value = "SELECT * FROM film f" +
            " INNER JOIN rating r ON f.film_id = r.film_id" +
            " WHERE r.user_id = ?1", nativeQuery = true)
    List<Film> getUserRatings(long userId);

    @Query(value = "SELECT * FROM film f" +
            " LEFT JOIN rating r ON f.film_id = r.film_id" +
            " LEFT JOIN review k ON f.film_id = k.film_id" +
            " WHERE f.tipus = ?1" +
            " GROUP BY f.film_id ORDER BY coalesce(avg(r.value + k.rating),0) DESC LIMIT 10" , nativeQuery = true)
    List<Film> findTop10(String type);

    @Query(value = " SELECT * FROM film f" +
            " WHERE mufaj LIKE %?1% " +
            " AND f.tipus = ?2", nativeQuery = true)
    List<Film> getFilmByGenres(String genre, String type);

    @Query(value = " SELECT * FROM film f" +
            " WHERE cim LIKE %?1% " +
            " AND f.tipus = ?2", nativeQuery = true)
    List<Film> getFilmByTitle(String title, String type);



    @Query(value="SELECT actor.name, part FROM actor_films a,actor WHERE a.film_id =?1 AND a.actor_id=actor.actor_id", nativeQuery = true)
    List<String> findActor(Long id);
    @Query(value="SELECT * FROM actor ", nativeQuery = true)
    List<String[]> actorList();
   /* @Query(value="SELECT part FROM actor_films a,actor WHERE a.film_id =?1 AND a.actor_id=actor.actor_id", nativeQuery = true)
    List<String> findPart(Long id);*/








}