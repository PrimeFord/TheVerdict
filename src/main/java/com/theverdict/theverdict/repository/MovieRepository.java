package com.theverdict.theverdict.repository;

import com.theverdict.theverdict.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}