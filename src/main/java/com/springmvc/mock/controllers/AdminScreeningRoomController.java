package com.springmvc.mock.controllers;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.mock.models.ScreeningRoom;
import com.springmvc.mock.models.Seat;
import com.springmvc.mock.services.AdminScreeningRoomService;
import com.springmvc.mock.services.AdminSeatService;

@Controller
@RequestMapping("/screeningrooms")
public class AdminScreeningRoomController {

	@Autowired
	private AdminScreeningRoomService screeningRoomService;
	
	@Autowired
	private AdminSeatService seatService;
	
	@GetMapping
	public String listScreeningRoom(Model model) {
		screeningRoomService.updateAllScreeningRoomsTotalSeats();
		model.addAttribute("screeningrooms", screeningRoomService.getAllScreeningRoom());
		return "listScreeningRoom";
	}
	
	@GetMapping("/create")
	public String showCreate(Model model) {
		List<Seat> seats = seatService.getAllSeat();
	    model.addAttribute("roles", seats);  
		return "adminCreateRoom";
	}
	
	@PostMapping("/createroom")
	public String createRoom(
			@RequestParam("room_name") String room_name
			) {
		ScreeningRoom room = new ScreeningRoom();
		room.setRoom_name(room_name);
		screeningRoomService.saveScreeningRoom(room);
		return "redirect:/screeningrooms";
	}
	
	@PostMapping("/update")
	public String updateRoom(
	        @RequestParam("id") Long id,
	        @RequestParam("room_name") String room_name) {
	    ScreeningRoom room = screeningRoomService.getScreeningRoomById(id);
	    if (room != null) {
	        room.setRoom_name(room_name);
	        screeningRoomService.saveScreeningRoom(room);
	    }
	    return "redirect:/screeningrooms";
	}
	
	@PostMapping("/delete")
	public String deleteRoom(
			@RequestParam("id") Long id
			) {
		screeningRoomService.deleteScreeningRoom(id);
		return "redirect:/screeningrooms";
	}
}
