package com.theatre.dao;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.theatre.model.Performance;
import com.theatre.util.DatabaseUtil;

/**
 * Data Access Object (DAO) class for managing Performance entities.
 */
public class PerformanceDAO {

	/**
	 * Retrieves a list of performances by the specified show ID.
	 * 
	 * @param showId The ID of the show.
	 * @return A list of performances for the given show ID.
	 * @throws SQLException If a database access error occurs.
	 */
	public List<Performance> getPerformancesByShowId(int showId) throws SQLException {
		String query = "SELECT * FROM performances WHERE show_id = ?";
		return getPerformances(query, pstmt -> pstmt.setInt(1, showId));
	}

	/**
	 * Retrieves a list of performances by the specified date.
	 * 
	 * @param date The date of the performances.
	 * @return A list of performances for the given date.
	 * @throws SQLException If a database access error occurs.
	 */
	public List<Performance> getPerformancesByDate(Date date) throws SQLException {
		String query = "SELECT * FROM performances WHERE date = ?";
		return getPerformances(query, pstmt -> pstmt.setDate(1, new java.sql.Date(date.getTime())));
	}

	/**
	 * Retrieves a list of performances based on the given query and parameter
	 * setter.
	 * 
	 * @param query  The SQL query to execute.
	 * @param setter The prepared statement setter to set query parameters.
	 * @return A list of performances.
	 * @throws SQLException If a database access error occurs.
	 */
	private List<Performance> getPerformances(String query, PreparedStatementSetter setter) throws SQLException {
		List<Performance> performances = new ArrayList<>();
		try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			setter.setValues(pstmt);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					Performance performance = new Performance();
					performance.setId(rs.getInt("id"));
					performance.setShowId(rs.getInt("show_id"));
					performance.setDate(rs.getDate("date"));
					performance.setTime(LocalTime.parse(rs.getString("time"))); // Parse time string to LocalTime
					performance.setDuration(rs.getInt("duration"));
					performance.setPrice(rs.getDouble("price"));
					performance.setAvailableTickets(rs.getInt("available_tickets"));
					performances.add(performance);
				}
			}
		}
		return performances;
	}

	/**
	 * Functional interface for setting parameters on a PreparedStatement.
	 */
	private interface PreparedStatementSetter {
		void setValues(PreparedStatement pstmt) throws SQLException;
	}
}
