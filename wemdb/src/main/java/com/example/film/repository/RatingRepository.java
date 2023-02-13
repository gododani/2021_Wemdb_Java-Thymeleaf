package com.example.film.repository;

import com.example.film.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
   Rating findByUserIdAndFilmId(long userId, long filmId);

   @Query(value = "SELECT coalesce(avg(value), 0) FROM Rating WHERE filmId = ?1")
   Double avg(long id);

   @Query(value = "SELECT count(value) FROM Rating WHERE filmId = ?1")
   Integer count(long id);

   @Query(value = "SELECT k.rating as krate, r.value as rrate, coalesce(avg(krate, rrate),0) as rate," +
           " FROM rating r, review k " +
           "WHERE r.film_id = ?1 and k.film_id = ?1", nativeQuery = true)
   Double fullRate(long id);

   List<Rating> findAllByFilmId(long id);

   void deleteByUserIdAndFilmId(Long userId, Long filmId);
}
