package com.theverdict.theverdict.observer;


import com.theverdict.theverdict.model.Movie;

public interface MovieObserver {
    void notify(Movie movie);
}