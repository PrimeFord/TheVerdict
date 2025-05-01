package com.theverdict.theverdict.service;

import com.theverdict.theverdict.factory.MovieFactory;
import com.theverdict.theverdict.model.Movie;
import com.theverdict.theverdict.observer.MovieObserver;
import com.theverdict.theverdict.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    private List<MovieObserver> observers = new ArrayList<>();

    // Add an observer
    public void addObserver(MovieObserver observer) {
        observers.add(observer);
    }

    // Notify all observers
    private void notifyObservers(Movie movie) {
        for (MovieObserver observer : observers) {
            observer.notify(movie);
        }
    }

    // Create a new Movie using Factory Pattern
    public Movie createMovie(String title, String description, String genre, LocalDate releaseDate) {
        Movie movie = MovieFactory.createMovie(title, description, genre, releaseDate);
        Movie savedMovie = movieRepository.save(movie);

        notifyObservers(savedMovie); // 🚀 Notify after movie created!

        return savedMovie;
    }

//    // Create a new Movie using Factory Pattern
//    public Movie createMovie(String title, String description, String genre, LocalDate releaseDate) {
//        Movie movie = MovieFactory.createMovie(title, description, genre, releaseDate);
//        return movieRepository.save(movie);
//    }

    // Get all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Get a movie by ID
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    // Update a movie (full update)
    public Optional<Movie> updateMovie(Long id, Movie updatedMovie) {
        return movieRepository.findById(id).map(existingMovie -> {
            existingMovie.setTitle(updatedMovie.getTitle());
            existingMovie.setDescription(updatedMovie.getDescription());
            existingMovie.setGenre(updatedMovie.getGenre());
            existingMovie.setReleaseDate(updatedMovie.getReleaseDate());
            return movieRepository.save(existingMovie);
        });
    }

    // Delete a movie
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}