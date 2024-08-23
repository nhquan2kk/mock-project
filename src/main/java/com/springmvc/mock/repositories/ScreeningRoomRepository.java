package com.springmvc.mock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springmvc.mock.models.ScreeningRoom;

public interface ScreeningRoomRepository  extends JpaRepository<ScreeningRoom, Long>{
	
}
