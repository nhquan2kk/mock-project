package com.springmvc.mock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.mock.models.Ticket;
import com.springmvc.mock.repositories.TicketRepository;

@Service
public class AdminTicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	public List<Ticket> getAllTicket(){
		return ticketRepository.findAll();
	}
	
	public Ticket getTicketById(Long id) {
		return ticketRepository.findById(id).orElse(null);
	}
	
	public void saveTicket(Ticket ticket) {
		ticketRepository.save(ticket);
	}
	
	public void deleteTicket(Long id) {
		ticketRepository.deleteById(id);
	}
}
