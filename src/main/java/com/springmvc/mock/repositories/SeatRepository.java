package com.springmvc.mock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.mock.models.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long>{
	
}
