package com.youcode.evalux.services.interfaces;

import com.youcode.evalux.entities.Review;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    Review saveReview(Review review);

    Review getReviewById(UUID id);

    List<Review> getAllReviews();

    void deleteReview(UUID id);
}
