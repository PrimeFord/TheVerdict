package com.theverdict.theverdict.controller;


import com.theverdict.theverdict.model.Movie;
import com.theverdict.theverdict.observer.AdminObserver;
import com.theverdict.theverdict.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @PostMapping
    public Movie createMovie(@RequestBody Movie movieRequest) {
        // Attach observer before creating movie
        AdminObserver adminObserver = new AdminObserver("admin1@example.com"); // Dummy email
        movieService.addObserver(adminObserver);

        return movieService.createMovie(
                movieRequest.getTitle(),
                movieRequest.getDescription(),
                movieRequest.getGenre(),
                movieRequest.getReleaseDate()
        );
    }

    // Get all movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // Get single movie by ID
    @GetMapping("/{id}")
    public Optional<Movie> getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    // Update movie
    @PutMapping("/{id}")
    public Optional<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        return movieService.updateMovie(id, updatedMovie);
    }

    // Delete movie
    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "Movie deleted successfully.";
    }
}