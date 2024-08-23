package com.springmvc.mock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.mock.models.Showtime;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long>{

}
