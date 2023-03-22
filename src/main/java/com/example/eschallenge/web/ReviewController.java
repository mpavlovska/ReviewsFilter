package com.example.eschallenge.web;

import com.example.eschallenge.model.Review;
import com.example.eschallenge.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/all-reviews")
    public String getAllReviews(@RequestParam(defaultValue = "true",required = false) Boolean isHighestFirst,
                                @RequestParam(defaultValue = "1", required = false) Integer minRating,
                                @RequestParam(defaultValue = "true",required = false) Boolean isNewestFirst,
                                @RequestParam(defaultValue = "false",required = false) Boolean isPrioritized,
                                Model model){
        if(isHighestFirst == null && minRating == null && isNewestFirst == null && isPrioritized == null){
            List<Review> reviews = reviewService.getAllReviews();
            model.addAttribute("reviews", reviews );

            return "filter-page";
        }

        List<Review> reviews = reviewService.filterReviews(isHighestFirst, minRating, isNewestFirst, isPrioritized);
        model.addAttribute("reviews", reviews);

        return "filter-page";
    }
}
