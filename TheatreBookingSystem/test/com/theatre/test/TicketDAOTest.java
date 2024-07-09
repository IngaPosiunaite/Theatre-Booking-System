package com.theatre.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.theatre.dao.TicketDAO;
import com.theatre.model.Ticket;

/**
 * Unit tests for the TicketDAO class.
 */
public class TicketDAOTest {
	private TicketDAO ticketDAO;

	@BeforeEach
	public void setUp() {
		// Initialise the TicketDAO instance before each test
		ticketDAO = new TicketDAO();
	}

	/**
	 * Test saving a ticket to the database.
	 */
	@Test
	public void testSaveTicket() {
		// Create a new Ticket instance
		Ticket ticket = new Ticket();
		ticket.setPerformanceId(1);
		ticket.setSeatType("stalls");
		ticket.setConcessionary(false);

		try {
			// Save the ticket to the database
			ticketDAO.saveTicket(ticket);

			// Verify that the ticket ID is not null after saving
			assertNotNull(ticket.getId(), "The ticket ID should not be null after saving");
		} catch (SQLException e) {
			// If an SQL exception occurs, the test fails
			fail("SQL exception: " + e.getMessage());
		}
	}
}
