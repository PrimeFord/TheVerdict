package com.theverdict.theverdict.strategy;

import com.theverdict.theverdict.model.Rating;

import java.util.List;

public interface RatingStrategy {
    double calculateAverage(List<Rating> ratings);
}