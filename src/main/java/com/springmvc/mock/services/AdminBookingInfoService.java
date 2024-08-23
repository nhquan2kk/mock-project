package com.springmvc.mock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.mock.models.BookingInfo;
import com.springmvc.mock.repositories.BookingInfoRepository;

@Service
public class AdminBookingInfoService {
	
	@Autowired
	private BookingInfoRepository bookingInfoRepository;
	
	public List<BookingInfo> getAllBookingInfo(){
		return bookingInfoRepository.findAll();
	}
	
	public BookingInfo getBookingInfoById(Long id) {
		return bookingInfoRepository.findById(id).orElse(null);
	}
	
	public void saveBookingInfo(BookingInfo bookingInfo) {
		bookingInfoRepository.save(bookingInfo);
	}
	
	public void deleteBookingInfo(Long id) {
		bookingInfoRepository.deleteById(id);
	}
}
