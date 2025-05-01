package com.theverdict.theverdict.repository;

import com.theverdict.theverdict.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}