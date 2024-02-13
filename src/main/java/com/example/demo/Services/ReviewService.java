package com.example.demo.Services;



import com.example.demo.model.Review;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    Review saveReview(Review review);

    Review getReviewById(UUID id);

    List<Review> getAllReviews();

    void deleteReview(UUID id);

    Review claimReview(UUID idReview);

    List<Review> reviewsReported();

    Review updateReview(Review review);
}
