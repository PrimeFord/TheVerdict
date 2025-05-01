package com.theverdict.theverdict.service;

import com.theverdict.theverdict.model.Movie;
import com.theverdict.theverdict.model.Rating;
import com.theverdict.theverdict.model.User;
import com.theverdict.theverdict.repository.MovieRepository;
import com.theverdict.theverdict.repository.RatingRepository;
import com.theverdict.theverdict.repository.UserRepository;
import com.theverdict.theverdict.strategy.RatingStrategy;
import com.theverdict.theverdict.strategy.SimpleAverageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    private RatingStrategy ratingStrategy = new SimpleAverageStrategy(); // Default strategy

    // Set different strategy (future flexibility)
    public void setRatingStrategy(RatingStrategy strategy) {
        this.ratingStrategy = strategy;
    }

    // Add a rating to a movie
    public Rating addRating(Long userId, Long movieId, Integer ratingValue) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Rating rating = new Rating(ratingValue, user, movie);
        Rating savedRating = ratingRepository.save(rating);

        // Update movie's average rating using Strategy Pattern
        List<Rating> movieRatings = ratingRepository.findAll(); // Ideally filter by movieId
        double average = ratingStrategy.calculateAverage(movieRatings);
        movie.setAverageRating(average);
        movieRepository.save(movie);

        return savedRating;
    }
}