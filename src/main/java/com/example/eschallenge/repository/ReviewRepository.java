package com.example.eschallenge.repository;

import com.example.eschallenge.data.ReviewsLoader;
import com.example.eschallenge.model.Review;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewRepository {
    public List<Review> getAllReviews() {
        return ReviewsLoader.ALL_REVIEWS;
    }
}
