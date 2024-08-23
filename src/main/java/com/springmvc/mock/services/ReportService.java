package com.springmvc.mock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.mock.models.Report;
import com.springmvc.mock.repositories.ReportRepository;

import java.util.List;

@Service
public class ReportService {
	
	@Autowired
	private ReportRepository reportRepository;
	
	public List<Report> getAllReports(){
		return reportRepository.findAll();
	}
	
	public Report getReportById(Long id) {
		return reportRepository.findById(id).orElse(null);
	}
	
	public void saveReport(Report report) {
		reportRepository.save(report);
	}
	
	public void deleteReport(Long id) {
		reportRepository.deleteById(id);
	}
}
