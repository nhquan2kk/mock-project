package com.springmvc.mock.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.mock.models.Booking;
import com.springmvc.mock.services.AdminBookingService;
import com.springmvc.mock.services.AdminShowtimeService;

@Controller
@RequestMapping("/bookings")
public class AdminBookingController {

	@Autowired
	private AdminBookingService bookingService;
	
	@Autowired
	private AdminShowtimeService showtimeService;
	
	@GetMapping
	public String listBooking(Model model) {
		model.addAttribute("bookings", bookingService.getAllBooking());
		model.addAttribute("showtimes", showtimeService.getAllShowtime());
		return "listBooking";
	}
	
	@GetMapping("/create")
	public String showBookingForm(Model model) {
		model.addAttribute("showtimes", showtimeService.getAllShowtime());
		return "adminCreateBooking";
	}
	
	@PostMapping("/save")
	public String createBooking(
			@RequestParam("email") String email,
			@RequestParam("date") LocalDateTime date,
			@RequestParam("showtime.id") Long showtimeId
			) {
		try {
			Booking booking = new Booking();
			booking.setEmail(email);
			booking.setDate(date);
			booking.setShowtime(showtimeService.getShowtimeById(showtimeId));
			bookingService.saveBooking(booking);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/bookings";
	}
	
	@PostMapping("/update")
	public String updateBooking(
			Model model,
			@RequestParam("booking_id") Long booking_id, 
			@RequestParam("email") String email,
			@RequestParam("date") LocalDateTime date,
			@RequestParam("showtime.id") Long showtimeId
			) {
		try {
			Booking booking = new Booking();
			model.addAttribute("showtimes", showtimeService.getAllShowtime());
			if(booking != null) {
				booking.setBooking_id(booking_id);
				booking.setEmail(email);
				booking.setDate(date);
				booking.setShowtime(showtimeService.getShowtimeById(showtimeId));
				bookingService.saveBooking(booking);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/bookings";
	}
	
	@PostMapping("/delete")
	public String deleteBooking(@RequestParam("id") Long id) {
		bookingService.deleteBooking(id);
		return "redirect:/bookings";
	}
}
