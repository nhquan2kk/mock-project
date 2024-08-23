package com.springmvc.mock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.mock.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{
	Booking findBookingByEmail(String email);
}
