package com.example.eschallenge.service;

import java.util.List;
import com.example.eschallenge.model.Review;

public interface ReviewService {
    List<Review> getAllReviews();
    List<Review> filterReviews(Boolean isHighestFirst, Integer minRating, Boolean isNewestFirst, Boolean isPrioritized);
}
