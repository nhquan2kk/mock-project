package com.springmvc.mock.controllers;

import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.mock.models.Report;
import com.springmvc.mock.repositories.ContactRepository;
import com.springmvc.mock.repositories.ReportRepository;
import com.springmvc.mock.services.ReportService;


@Controller
@RequestMapping("/contact")
public class ContactController {

	@GetMapping
	public String showContactPage() {
		return "contact";
	}
	
	@Autowired
	private ReportService reportService;
	
	@PostMapping("/submit")
	public String submitContactForm(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("title") String title,
			@RequestParam("detail") String detail
			) {
		Report report = new Report();
		report.setName(name);
		report.setEmail(email);
		report.setTitle(title);
		report.setDetail(detail);
		reportService.saveReport(report);
		
		return "thanks";
	}
	
	@PostMapping("/delreport")
	public String delReport(@RequestParam("id") Long id) {
		reportService.deleteReport(id);
		return "redirect:/reports";
	}
	
	@PostMapping("/updatereport")
	public String updateReport(
			@RequestParam("id") Long id,
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("title") String title,
			@RequestParam("detail") String detail
			) {
		Report report = reportService.getReportById(id);
		if(report != null) {
			report.setName(name);
			report.setEmail(email);
			report.setTitle(title);
			report.setDetail(detail);
			reportService.saveReport(report);
		}
		return "redirect:/reports";
	}
	
	
}
