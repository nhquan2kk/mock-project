package com.springmvc.mock.controllers;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomeController {

	@GetMapping("/adminhome")
	public String adminHome() {
		return "adminhome";
	}
}
