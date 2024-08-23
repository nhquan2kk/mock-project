package com.springmvc.mock.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.mock.models.Showtime;
import com.springmvc.mock.services.AdminMovieService;
import com.springmvc.mock.services.AdminScreeningRoomService;
import com.springmvc.mock.services.AdminShowtimeService;

@Controller
@RequestMapping("/showtimes")
public class AdminShowtimeController {

	@Autowired
	private AdminShowtimeService showtimeService;
	
	@Autowired
	private AdminMovieService movieService;
	
	@Autowired
	private AdminScreeningRoomService roomService;
	
	@GetMapping
	public String listShowtime(Model model) {
		model.addAttribute("showtimes", showtimeService.getAllShowtime());
		model.addAttribute("movies", movieService.getAllMovie());
		model.addAttribute("rooms", roomService.getAllScreeningRoom());
		return "listShowtime";
	}
	
	@GetMapping("/create")
	public String showCreateForm(Model model) {
		model.addAttribute("movies", movieService.getAllMovie());
		model.addAttribute("rooms", roomService.getAllScreeningRoom());
		return "adminCreateShowtime";
	}
	
	@PostMapping("save")
	public String saveShowtime(
			@RequestParam("movie.id") Long movieId,
			@RequestParam("room.id") Long roomId,
			@RequestParam("showtime_date") LocalDateTime showtime_date,
			@RequestParam("fee") Integer fee
			) {
		try {
			Showtime showtime = new Showtime();
			showtime.setMovie(movieService.getMovieById(movieId));
			showtime.setScreeningRoom(roomService.getScreeningRoomById(roomId));
			showtime.setShowtimeDate(showtime_date);
			showtime.setFee(fee);
			showtimeService.saveShowtime(showtime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/showtimes";
	}
	
	@PostMapping("/update")
	public String updateShowtime(
			Model model,
			@RequestParam("id") Long id,
			@RequestParam("movie.id") Long movieId,
			@RequestParam("room.id") Long roomId,
			@RequestParam("showtime_date") LocalDateTime showtime_date,
			@RequestParam("fee") Integer fee
			) {
		try {
			Showtime showtime = new Showtime();
			if(showtime != null) {
				showtime.setId(id);
				showtime.setMovie(movieService.getMovieById(movieId));
				showtime.setScreeningRoom(roomService.getScreeningRoomById(roomId));
				showtime.setShowtimeDate(showtime_date);
				showtime.setFee(fee);
				showtimeService.saveShowtime(showtime);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/showtimes";
	}
	
	@PostMapping("/delete")
	public String deleteShowtime(
			@RequestParam("id") Long id
			) {
		showtimeService.deleteShowtime(id);
		return "redirect:/showtimes";
	}
}
