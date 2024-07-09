package com.theatre.services;

import java.sql.SQLException;

import com.theatre.dao.TicketDAO;
import com.theatre.model.Ticket;

/**
 * Service class for managing Ticket-related operations.
 */
public class TicketService {
	private TicketDAO ticketDAO;

	/**
	 * Default constructor that initialises TicketDAO.
	 */
	public TicketService() {
		this.ticketDAO = new TicketDAO();
	}

	/**
	 * Constructor for dependency injection, useful for testing.
	 * 
	 * @param ticketDAO The TicketDAO instance to use.
	 */
	public TicketService(TicketDAO ticketDAO) {
		this.ticketDAO = ticketDAO;
	}

	/**
	 * Saves a ticket.
	 * 
	 * @param ticket The ticket to be saved.
	 * @throws SQLException If a database access error occurs.
	 */
	public void saveTicket(Ticket ticket) throws SQLException {
		ticketDAO.saveTicket(ticket);
	}
}
