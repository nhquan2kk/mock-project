package com.springmvc.mock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.mock.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
