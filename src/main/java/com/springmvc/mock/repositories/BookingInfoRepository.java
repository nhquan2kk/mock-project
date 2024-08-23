package com.springmvc.mock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.mock.models.BookingInfo;

public interface BookingInfoRepository extends JpaRepository<BookingInfo, Long>{

}
