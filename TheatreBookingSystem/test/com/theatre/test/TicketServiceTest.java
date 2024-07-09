package com.theatre.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.theatre.dao.TicketDAO;
import com.theatre.model.Ticket;
import com.theatre.services.TicketService;

/**
 * Unit tests for the TicketService class.
 */
public class TicketServiceTest {
    private TicketService ticketService;

    @BeforeEach
    public void setUp() {
        // Initialise the TicketService instance with a stubbed TicketDAO
        ticketService = new TicketService(new StubTicketDAO());
    }

    /**
     * Test saving a ticket.
     */
    @Test
    public void testSaveTicket() {
        // Create a new Ticket instance
        Ticket ticket = new Ticket();
        ticket.setPerformanceId(1);
        ticket.setSeatType("stalls");
        ticket.setConcessionary(false);

        try {
            // Save the ticket using the service
            ticketService.saveTicket(ticket);

            // Verify that the ticket ID is not null after saving
            assertNotNull(ticket.getId(), "The ticket ID should not be null after saving");
        } catch (SQLException e) {
            // If an SQL exception occurs, the test fails
            fail("SQL exception: " + e.getMessage());
        }
    }

    /**
     * Stub implementation of TicketDAO for testing purposes.
     */
    private class StubTicketDAO extends TicketDAO {
        @Override
        public void saveTicket(Ticket ticket) throws SQLException {
            // Simulate saving the ticket by setting a mock ID
            ticket.setId(1);
        }
    }
}
