package com.springmvc.mock.controllers;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.mock.models.Seat;
import com.springmvc.mock.services.AdminScreeningRoomService;
import com.springmvc.mock.services.AdminSeatService;

@Controller
@RequestMapping("/seats")
public class AdminSeatController {
	
	@Autowired
	private AdminSeatService adminSeatService;
	
	@Autowired
	private AdminScreeningRoomService adminScreeningRoom;
	
	@GetMapping
	public String listSeat(Model model) {
		model.addAttribute("rooms", adminScreeningRoom.getAllScreeningRoom());
		model.addAttribute("seats", adminSeatService.getAllSeat());
		return "listSeat";
	}
	
	@GetMapping("/create")
	public String createForm(Model model) {
		model.addAttribute("rooms", adminScreeningRoom.getAllScreeningRoom());
		return "adminCreateSeat";
	}
	
	@PostMapping("/createseat")
	public String createSeat(
			@RequestParam("screeningrooms.id") Long screeningroomsId,
			@RequestParam("row_number") int row_number,
			@RequestParam("column_number") int column_number
			) {
		Seat seat = new Seat();
		seat.setScreeningroom(adminScreeningRoom.getScreeningRoomById(screeningroomsId));
		seat.setRow_number(row_number);
		seat.setColumn_number(column_number);
		adminSeatService.saveSeat(seat);
		return "redirect:/seats";
	}
	
	@PostMapping("/update")
	public String updateSeat(
			Model model,
			@RequestParam("id") Long id,
			@RequestParam("room.id") Long roomId,
			@RequestParam("row_number") int row_number,
			@RequestParam("column_number") int column_number
			) {
		Seat seat = new Seat();
		if(seat != null) {
			seat.setId(id);
			seat.setRow_number(row_number);
			seat.setColumn_number(column_number);
			seat.setScreeningroom(adminScreeningRoom.getScreeningRoomById(roomId));
			adminSeatService.saveSeat(seat);
		}
		return "redirect:/seats";
	}
	
	@PostMapping("/delete")
	public String deleteSeat(
			@RequestParam("id") Long id
			) {
		adminSeatService.delSeat(id);
		return "redirect:/seats";
	}
}
