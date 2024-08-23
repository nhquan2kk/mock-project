package com.springmvc.mock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.mock.models.ScreeningRoom;
import com.springmvc.mock.models.Seat;
import com.springmvc.mock.repositories.ScreeningRoomRepository;
import com.springmvc.mock.repositories.SeatRepository;

@Service
public class AdminScreeningRoomService {

	@Autowired
	private ScreeningRoomRepository screeningRoomRepository;
	
	
//	public List<ScreeningRoom> getAllScreeningRoom(){
//		return screeningRoomRepository.findAll();
//	}
	
	@Transactional(readOnly = true)
    public List<ScreeningRoom> getAllScreeningRoom() {
		List<ScreeningRoom> screeningRooms = screeningRoomRepository.findAll();
	    for (ScreeningRoom room : screeningRooms) {
	        room.calculateTotalSeat();
	        screeningRoomRepository.save(room);
	    }
	    return screeningRooms;
    }
	
	@Transactional
	public void updateAllScreeningRoomsTotalSeats() {
	    List<ScreeningRoom> screeningRooms = screeningRoomRepository.findAll();
	    for (ScreeningRoom room : screeningRooms) {
	        room.calculateTotalSeat();
	        screeningRoomRepository.save(room);
	    }
	}
	
	@Transactional
	public ScreeningRoom getScreeningRoomById(Long id) {
		return screeningRoomRepository.findById(id).orElse(null);
	}
	
//	public void saveScreeningRoom(ScreeningRoom screeningRoom) {
//		screeningRoomRepository.save(screeningRoom);
//	}
	
	@Transactional
	public void saveScreeningRoom(ScreeningRoom screeningRoom) {
	    screeningRoom.calculateTotalSeat();
	    screeningRoomRepository.save(screeningRoom);
	}
	
	public void deleteScreeningRoom(Long id) {
		screeningRoomRepository.deleteById(id);
	}
	
	
}
