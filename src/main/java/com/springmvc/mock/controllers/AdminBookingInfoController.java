package com.springmvc.mock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.mock.models.Booking;
import com.springmvc.mock.models.BookingInfo;
import com.springmvc.mock.services.AdminBookingInfoService;
import com.springmvc.mock.services.AdminBookingService;
import com.springmvc.mock.services.AdminSeatService;

@Controller
@RequestMapping("/bookinginfos")
public class AdminBookingInfoController {

	@Autowired
	private AdminBookingInfoService bookingInfoService;
	
	@Autowired
	private AdminBookingService bookingService;
	
	@Autowired
	private AdminSeatService seatService;
	
	@GetMapping
	public String listBookingInfo(Model model) {
		model.addAttribute("bookinginfos", bookingInfoService.getAllBookingInfo());
		model.addAttribute("seats", seatService.getAllSeat());
		model.addAttribute("bookings", bookingService.getAllBooking());
		return "listBookingInfo";
	}
	
	@GetMapping("/create")
	public String showBookingInfoForm(Model model) {
		model.addAttribute("bookings", bookingService.getAllBooking());
		model.addAttribute("seats", seatService.getAllSeat());
		return "adminCreateBookingInfo";
	}
	
	@PostMapping("/save")
	public String createBookingInfo(
			@RequestParam("booking.id") Long bookingId,
			@RequestParam("seat.id") Long seatId
			) {
		try {
			BookingInfo bookingInfo = new BookingInfo();
			bookingInfo.setBooking(bookingService.findBookingById(bookingId));
			bookingInfo.setSeat(seatService.getSeatById(seatId));
			bookingInfoService.saveBookingInfo(bookingInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/bookinginfos";
	}
	
	@PostMapping("/update")
	public String updateBookingInfo(
			Model model,
			@RequestParam("id") Long id,
			@RequestParam("booking.id") Long bookingId,
			@RequestParam("seat.id") Long seatId
			) {
		try {
			BookingInfo bookingInfo = new BookingInfo();
			if(bookingInfo != null) {
				bookingInfo.setId(id);
				bookingInfo.setBooking(bookingService.findBookingById(bookingId));
				bookingInfo.setSeat(seatService.getSeatById(seatId));
				bookingInfoService.saveBookingInfo(bookingInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/bookinginfos";
	}
	
	@PostMapping("/delete")
	public String deleteBookingInfo(@RequestParam("id") Long id) {
		bookingInfoService.deleteBookingInfo(id);
		return "redirect:/bookinginfos";
	}
	
}
