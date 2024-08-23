package com.springmvc.mock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.mock.models.Ticket;
import com.springmvc.mock.services.AdminBookingService;
import com.springmvc.mock.services.AdminSeatService;
import com.springmvc.mock.services.AdminShowtimeService;
import com.springmvc.mock.services.AdminTicketService;

@Controller
@RequestMapping("/tickets")
public class AdminTicketController {

	@Autowired
	private AdminTicketService adminTicketService;
	
	@Autowired
	private AdminBookingService bookingService;
	
	@GetMapping
	public String listTicket(Model model) {
		model.addAttribute("tickets", adminTicketService.getAllTicket());
		model.addAttribute("bookings", bookingService.getAllBooking());
		return "listTicket";
	}
	
	@GetMapping("/create")
	public String createTicketForm(Model model) {
		model.addAttribute("bookings", bookingService.getAllBooking());
		return "adminCreateTicket";
	}
	
	@PostMapping("/save")
	public String createTicket(
			@RequestParam("booking.id") Long bookingId,
			@RequestParam("status") boolean status,
			@RequestParam("totalPayment") Double totalPayment
			) {
		try {
			Ticket ticket = new Ticket();
			ticket.setBooking(bookingService.findBookingById(bookingId));
			ticket.setStatus(status);
			ticket.setTotalPayment(totalPayment);
			adminTicketService.saveTicket(ticket);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/tickets";
	}
	
	@PostMapping("/update")
	public String updateTicket(
			@RequestParam("id") Long id,
			@RequestParam("booking.id") Long bookingId,
			@RequestParam("status") boolean status,
			@RequestParam("totalPayment") Double totalPayment
			) {
		try {
			Ticket ticket = new Ticket();
			if(ticket != null) {
				ticket.setId(id);
				ticket.setBooking(bookingService.findBookingById(bookingId));
				ticket.setStatus(status);
				ticket.setTotalPayment(totalPayment);
				adminTicketService.saveTicket(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/tickets";
	}
	
	
	@PostMapping("/delete")
	public String deleteTicket(@RequestParam("id") Long id) {
		adminTicketService.deleteTicket(id);
		return "redirect:/tickets";
	}
}
	