package com.theverdict.theverdict.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer ratingValue; // 1 to 5 stars

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // who rated

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie; // which movie was rated

    // Constructors
    public Rating() {}

    public Rating(Integer ratingValue, User user, Movie movie) {
        this.ratingValue = ratingValue;
        this.user = user;
        this.movie = movie;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Integer getRatingValue() { return ratingValue; }

    public void setRatingValue(Integer ratingValue) { this.ratingValue = ratingValue; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Movie getMovie() { return movie; }

    public void setMovie(Movie movie) { this.movie = movie; }
}