package com.theverdict.theverdict.controller;

import com.theverdict.theverdict.dto.RatingRequest;
import com.theverdict.theverdict.model.Rating;
import com.theverdict.theverdict.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    // Refactored to use @RequestBody
    @PostMapping
    public Rating addRating(@RequestBody RatingRequest ratingRequestDto) {
        return ratingService.addRating(
                ratingRequestDto.getUserId(),
                ratingRequestDto.getMovieId(),
                ratingRequestDto.getRatingValue()
        );
    }
}
//@RestController
//@RequestMapping("/api/ratings")
//public class RatingController {
//
//    @Autowired
//    private RatingService ratingService;
//
//    // Add a rating
//    @PostMapping
//    public Rating addRating(@RequestParam Long userId,
//                            @RequestParam Long movieId,
//                            @RequestParam Integer ratingValue) {
//        return ratingService.addRating(userId, movieId, ratingValue);
//    }
//}