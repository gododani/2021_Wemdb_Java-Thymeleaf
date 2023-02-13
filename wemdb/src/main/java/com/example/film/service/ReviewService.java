package com.example.film.service;

import com.example.film.model.Film;
import com.example.film.model.Rating;
import com.example.film.model.Review;
import com.example.film.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.util.List;

@Slf4j
@Service
@Transactional
public class ReviewService {
    private ReviewRepository reviewRepository;
    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviews(){
        return reviewRepository.findAll();
    }
    public List<Review> getFilmReview(long id) {
        return reviewRepository.getAllByFilmId(id);
    }
    public Review getByFilmIdAndUserId(Long filmId, Long userId) {
        return reviewRepository.getByFilmIdAndUserId(filmId, userId);
    }

    public int getFilmReviewCount(long id) {
        return reviewRepository.count(id);
    }

    public Double getFilmReviewAvg(long id) {
        return   Math.round(reviewRepository.avg(id) * 10.0)/10.0;
    }

    public List<Review> findAllByFilmId(long id){
        return reviewRepository.getAllByFilmId(id);
    }

    public void addReview(Review review)  {
        reviewRepository.save(review);
        log.info("Review added: " + review.toString());
    }

    public boolean reviewExist(long userId, long filmID) {
        Review r = reviewRepository.findByUserIdAndFilmId(userId, filmID);
        return r != null;
    }

    public void updateReview(Review review)  {
        Review r = getByFilmIdAndUserId(review.getFilmId(), review.getUserId());
        review.setId(r.getId());
        reviewRepository.save(review);
    }

    public void delReview(Review review) {
        reviewRepository.deleteByUserIdAndFilmId(review.getUserId(), review.getFilmId());
    }

}
