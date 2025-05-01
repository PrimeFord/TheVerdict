package com.theverdict.theverdict.factory;

import com.theverdict.theverdict.model.Movie;

import java.time.LocalDate;

public class MovieFactory {

    public static Movie createMovie(String title, String description, String genre, LocalDate releaseDate) {
        return new Movie(title, description, genre, releaseDate);
    }
}