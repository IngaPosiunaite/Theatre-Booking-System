package com.theatre.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.theatre.model.Ticket;

/**
 * Unit tests for the Ticket class.
 */
public class TicketTest {
	private Ticket ticket;

	@BeforeEach
	public void setUp() {
		// Initialise a new Ticket instance before each test
		ticket = new Ticket();
	}

	/**
	 * Test the getters and setters of the Ticket class.
	 */
	@Test
	public void testTicketSettersAndGetters() {
		// Set values for the Ticket instance
		ticket.setId(1);
		ticket.setPerformanceId(1);
		ticket.setSeatType("stalls");
		ticket.setConcessionary(false);

		// Assert that the values have been set correctly
		assertEquals(1, ticket.getId());
		assertEquals(1, ticket.getPerformanceId());
		assertEquals("stalls", ticket.getSeatType());
		assertFalse(ticket.isConcessionary());
	}

	/**
	 * Test the toString method of the Ticket class.
	 */
	@Test
	public void testToString() {
		// Set values for the Ticket instance
		ticket.setId(1);
		ticket.setPerformanceId(1);
		ticket.setSeatType("stalls");
		ticket.setConcessionary(false);

		// Assert that the toString method returns the expected string
		String expected = "Ticket{id=1, performanceId=1, seatType='stalls', concessionary=false}";
		assertEquals(expected, ticket.toString());
	}
}
