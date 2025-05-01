package com.theverdict.theverdict.dto;


public class RatingRequest {

    private Long userId;
    private Long movieId;
    private Integer ratingValue;

    // Constructors
    public RatingRequest() {}

    public RatingRequest(Long userId, Long movieId, Integer ratingValue) {
        this.userId = userId;
        this.movieId = movieId;
        this.ratingValue = ratingValue;
    }

    // Getters and Setters
    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public Long getMovieId() { return movieId; }

    public void setMovieId(Long movieId) { this.movieId = movieId; }

    public Integer getRatingValue() { return ratingValue; }

    public void setRatingValue(Integer ratingValue) { this.ratingValue = ratingValue; }
}