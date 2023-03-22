package com.example.eschallenge.data;

import com.example.eschallenge.model.Review;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReviewsLoader {
    public static List<Review> ALL_REVIEWS = new ArrayList<>();

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        ALL_REVIEWS = objectMapper.readValue(
                new ClassPathResource("reviews.json").getFile(),
                new TypeReference<List<Review>>(){}
        );
    }
}
