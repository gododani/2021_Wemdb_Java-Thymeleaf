package com.example.film.repository;

import com.example.film.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    Review findByUserIdAndFilmId(long userId, long filmId);

    @Query(value = "SELECT coalesce( avg(rating), 0) FROM Review WHERE filmId = ?1")
    Double avg(long id);

    @Query(value = "SELECT count(rating) FROM Review WHERE filmId = ?1")
    Integer count(long id);

    List<Review> getAllByFilmId(Long id);
    Review getByFilmIdAndUserId(Long filmId, Long UserId);

    void deleteByUserIdAndFilmId(Long userId, Long filmId);
}
