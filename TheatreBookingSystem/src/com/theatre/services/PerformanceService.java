package com.theatre.services;

import java.sql.SQLException;
import java.util.List;
import java.sql.Date;

import com.theatre.dao.PerformanceDAO;
import com.theatre.model.Performance;

/**
 * Service class for managing Performance-related operations.
 */
public class PerformanceService {
	private PerformanceDAO performanceDAO;

	/**
	 * Default constructor that initialises PerformanceDAO.
	 */
	public PerformanceService() {
		this.performanceDAO = new PerformanceDAO();
	}

	/**
	 * Constructor for dependency injection, useful for testing.
	 * 
	 * @param performanceDAO The PerformanceDAO instance to use.
	 */
	public PerformanceService(PerformanceDAO performanceDAO) {
		this.performanceDAO = performanceDAO;
	}

	/**
	 * Retrieves a list of performances by the specified show ID.
	 * 
	 * @param showId The ID of the show.
	 * @return A list of performances for the given show ID.
	 * @throws SQLException If a database access error occurs.
	 */
	public List<Performance> getPerformancesByShowId(int showId) throws SQLException {
		return performanceDAO.getPerformancesByShowId(showId);
	}

	/**
	 * Retrieves a list of performances by the specified date.
	 * 
	 * @param date The date of the performances.
	 * @return A list of performances for the given date.
	 * @throws SQLException If a database access error occurs.
	 */
	public List<Performance> getPerformancesByDate(Date date) throws SQLException {
		return performanceDAO.getPerformancesByDate(date);
	}
}
