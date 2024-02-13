package com.example.demo.Services.Impl;


import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Services.ReviewService;
import com.example.demo.model.DBUser;
import com.example.demo.model.Review;
import com.example.demo.repository.DBUserRepository;
import com.example.demo.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import com.example.demo.configuration.SpringSecurityConfig;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final DBUserRepository userRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, DBUserRepository userRepository){
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Review saveReview(Review review) {
        var user = userRepository.findByUsername(
                SpringSecurityConfig.getSessionUser()
        ).get();
        review.setRepoted(false);
        review.setUser(user);
        review.setDate(LocalDate.now());
        return reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(UUID id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public void deleteReview(UUID id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review claimReview(UUID idReview) {
        Review review = reviewRepository.findById(idReview)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + idReview));
        review.setRepoted(true);
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Review review) {
        Review r = reviewRepository.findById(review.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + review.getId()));
        r.setMessage(review.getMessage());
        r.setRepoted(false);
        return reviewRepository.save(r);
    }

    @Override
    public List<Review> reviewsReported() {
        return reviewRepository.findByReportedTrue();
    }
}
