package com.springmvc.mock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.mock.models.Booking;
import com.springmvc.mock.repositories.BookingRepository;

@Service
public class AdminBookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> getAllBooking(){
		return bookingRepository.findAll();
	}
	
	public Booking findBookingById(Long id) {
		return bookingRepository.findById(id).orElse(null);
	}
	
	public Booking findBookingByEmail(String email) {
		return bookingRepository.findBookingByEmail(email);
	}
	
	public void saveBooking(Booking booking) {
		bookingRepository.save(booking);
	}
	
	public void deleteBooking(Long id) {
		bookingRepository.deleteById(id);
	}
}
