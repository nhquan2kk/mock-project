package com.springmvc.mock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.mock.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
