package com.example.eschallenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Review {
    private Long id;
    private String reviewId;
    private String reviewFullText;
    private String reviewText;
    private Integer numLikes;
    private Integer numComments;
    private Integer numShares;
    private Integer rating;
    private String reviewCreatedOn;
    private Instant reviewCreatedOnDate;
    private Long reviewCreatedOnTime;
    private Long reviewerId;
    private String reviewerUrl;
    private String reviewerName;
    private String reviewerEmail;
    private String sourceType;
    private Boolean isVerified;
    private String source;
    private String sourceName;
    private String sourceId;
    private List<String> tags = new ArrayList<>();
    private String href;
    private String logoHref;
    private List<String> photos = new ArrayList<>();
}
