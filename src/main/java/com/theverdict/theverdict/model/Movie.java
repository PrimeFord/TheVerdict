package com.theverdict.theverdict.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String genre;

    private LocalDate releaseDate;

    private Double averageRating = 0.0; // Default when created

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Rating> ratings;

    // Constructors
    public Movie() {}

    public Movie(String title, String description, String genre, LocalDate releaseDate) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.averageRating = 0.0;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }

    public LocalDate getReleaseDate() { return releaseDate; }

    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }

    public Double getAverageRating() { return averageRating; }

    public void setAverageRating(Double averageRating) { this.averageRating = averageRating; }

    public List<Rating> getRatings() { return ratings; }

    public void setRatings(List<Rating> ratings) { this.ratings = ratings; }
}