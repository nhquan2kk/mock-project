package com.springmvc.mock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.mock.models.Seat;
import com.springmvc.mock.repositories.SeatRepository;

@Service
public class AdminSeatService {
	
	@Autowired
	private SeatRepository seatRepo;
	
	public List<Seat> getAllSeat(){
		return seatRepo.findAll();
	}
	
	public Seat getSeatById(Long id) {
		return seatRepo.findById(id).orElse(null);
	}
	
	public void saveSeat(Seat seat) {
		seatRepo.save(seat);
	}
	
	public void delSeat(Long id) {
		seatRepo.deleteById(id);
	}
}
