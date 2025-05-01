package com.theverdict.theverdict.strategy;

import com.theverdict.theverdict.model.Rating;

import java.util.List;

public class SimpleAverageStrategy implements RatingStrategy {

    @Override
    public double calculateAverage(List<Rating> ratings) {
        if (ratings.isEmpty()) return 0.0;

        double sum = 0;
        int count = 0;
        for (Rating rating : ratings) {
            sum += rating.getRatingValue();
            count++;
        }
        return sum / count;
    }
}