package com.theverdict.theverdict.observer;


import com.theverdict.theverdict.model.Movie;

public class AdminObserver implements MovieObserver {

    private String adminEmail;

    public AdminObserver(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    @Override
    public void notify(Movie movie) {
        System.out.println("📢 [ADMIN NOTIFICATION] Dear " + adminEmail + ", a new movie has been added: " + movie.getTitle());
    }
}