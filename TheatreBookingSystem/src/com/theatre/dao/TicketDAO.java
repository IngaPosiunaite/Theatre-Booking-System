package com.theatre.dao;

import java.sql.*;

import com.theatre.model.Ticket;
import com.theatre.util.DatabaseUtil;

/**
 * Data Access Object (DAO) class for managing Ticket entities.
 */
public class TicketDAO {

	/**
	 * Saves a ticket to the database.
	 * 
	 * @param ticket The ticket to be saved.
	 * @throws SQLException If a database access error occurs.
	 */
	public void saveTicket(Ticket ticket) throws SQLException {
		String query = "INSERT INTO tickets (performance_id, seat_type, is_concessionary) VALUES (?, ?, ?)";

		// Establish a connection, prepare the statement, and execute the update
		try (Connection conn = DatabaseUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

			// Set the parameters for the prepared statement
			pstmt.setInt(1, ticket.getPerformanceId());
			pstmt.setString(2, ticket.getSeatType());
			pstmt.setBoolean(3, ticket.isConcessionary());
			pstmt.executeUpdate();

			// Retrieve the generated key (ticket ID) and set it to the ticket
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				if (rs.next()) {
					ticket.setId(rs.getInt(1));
				}
			}
		}
	}
}
