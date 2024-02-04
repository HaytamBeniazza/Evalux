package com.example.demo.services.interfaces;

import com.example.demo.entity.Review;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    Review saveReview(Review review);

    Review getReviewById(UUID id);

    List<Review> getAllReviews();

    void deleteReview(UUID id);
}