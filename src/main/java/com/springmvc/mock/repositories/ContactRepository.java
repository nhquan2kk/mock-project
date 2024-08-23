package com.springmvc.mock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.mock.models.Report;

@Repository
public interface ContactRepository extends JpaRepository<Report, Long>{
	
}
