package com.springmvc.mock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.mock.models.Showtime;
import com.springmvc.mock.repositories.ShowtimeRepository;

@Service
public class AdminShowtimeService {

	@Autowired
	private ShowtimeRepository showtimeRepository;
	
	public List<Showtime> getAllShowtime(){
		return showtimeRepository.findAll();
	}
	
	public Showtime getShowtimeById(Long id) {
		return showtimeRepository.findById(id).orElse(null);
	}
	
	public void deleteShowtime(Long id) {
		showtimeRepository.deleteById(id);
	}
	
	public void saveShowtime(Showtime showtime) {
		showtimeRepository.save(showtime);
	}
}
