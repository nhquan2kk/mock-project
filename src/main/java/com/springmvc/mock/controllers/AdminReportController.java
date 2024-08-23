package com.springmvc.mock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springmvc.mock.models.Report;
import com.springmvc.mock.services.ReportService;

@Controller
public class AdminReportController {
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping("/reports")
	public String ListReport(Model model) {
		List<Report> reports = reportService.getAllReports();
		model.addAttribute("reports", reports);
		return "listReport";
	}
}
