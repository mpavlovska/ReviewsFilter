package com.example.eschallenge.service.impl;

import com.example.eschallenge.model.Review;
import com.example.eschallenge.repository.ReviewRepository;
import com.example.eschallenge.service.ReviewService;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.getAllReviews();
    }

    @Override
    public List<Review> filterReviews(Boolean isHighestFirst, Integer minRating, Boolean isNewestFirst, Boolean isPrioritized) {
        List<Review> allReviews = reviewRepository.getAllReviews();
        List<Review> minRatingList = filterByMinRating(minRating, allReviews);
        List<Review> ratingAndDateOrderedList = orderByRatingAndDate(isHighestFirst, isNewestFirst, minRatingList);


        return orderByText(isPrioritized, ratingAndDateOrderedList);
    }

    public List<Review> filterByMinRating(Integer minRating, List<Review> allReviews) {
        return allReviews.stream()
                .filter(review -> review.getRating() >= minRating)
                .collect(Collectors.toList());
    }

    private static List<Review> orderByRatingAndDate(Boolean highestFirst, Boolean newestFirst, List<Review> orderedReviews) {
        return orderedReviews.stream()
                .sorted(Comparator.comparing(Review::getRating, highestFirst ? Comparator.reverseOrder() : Comparator.naturalOrder())
                        .thenComparing(Review::getReviewCreatedOnDate, newestFirst ? Comparator.reverseOrder() : Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    private List<Review> orderByText(Boolean prioritize, List<Review> orderedReviews) {
        List<Review> reviewsWithText = orderedReviews.stream()
                .filter(review -> !review.getReviewText().isEmpty())
                .collect(Collectors.toList());

        List<Review> reviewsWithoutTexts = orderedReviews.stream()
                .filter(review -> review.getReviewText().isEmpty())
                .collect(Collectors.toList());

        if (prioritize) {
            reviewsWithText.addAll(reviewsWithoutTexts);
            return reviewsWithText;
        }
        return orderedReviews;
    }
}