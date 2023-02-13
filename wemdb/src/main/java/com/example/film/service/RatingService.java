package com.example.film.service;

import com.example.film.model.Rating;
import com.example.film.model.Review;
import com.example.film.repository.RatingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class RatingService {
    private RatingRepository ratingRepository;
    private ReviewService reviewService;

    @Autowired
    public void setRatingRepository(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Autowired
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    public int getFilmRatingCount(long id) {
        return ratingRepository.count(id);
    }

    public double getFilmRating(long id) {
        return  Math.round(ratingRepository.avg(id) * 10.0) / 10.0;
    }

    public double getFilmFullRating(long id) {
        double rating = 0.0;
        int ratings = 0;
        List<Rating> userRating = ratingRepository.findAllByFilmId(id);
        List<Review> kritikRating = reviewService.findAllByFilmId(id);

        for (Rating rate: userRating) {
            if(rate.getValue() == 0) continue;
            rating += rate.getValue();
            ratings++;
        }

        for (Review review: kritikRating) {
            if(review.getRating() == 0) continue;
            rating += review.getRating();
            ratings++;
        }

        if(ratings == 0) return 0;
        return Math.round(rating/ratings * 10.0) / 10.0;
    }

    public List<Rating> getRatings(){
        return (List<Rating>) ratingRepository.findAll();
    }

    public Rating getRatingByUserIdAndFilmId(long userId, long filmID) {
        return ratingRepository.findByUserIdAndFilmId(userId, filmID);
    }

    public boolean ratingExist(long userId, long filmID) {
        Rating r = ratingRepository.findByUserIdAndFilmId(userId, filmID);
        return r != null;
    }

    public void addRating(Rating rating) {
        ratingRepository.save(rating);
    }

    public void updateRating(Rating rating) {
        Rating r = ratingRepository.findByUserIdAndFilmId(rating.getUserId(), rating.getFilmId());
        r.setValue(rating.getValue());
        ratingRepository.save(r);
    }

    public void delRating(Rating rating) {
        ratingRepository.deleteByUserIdAndFilmId(rating.getUserId(), rating.getFilmId());
    }
}
