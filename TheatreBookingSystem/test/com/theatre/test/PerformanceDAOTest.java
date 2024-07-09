package com.theatre.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.theatre.dao.PerformanceDAO;
import com.theatre.model.Performance;

/**
 * Unit tests for the PerformanceDAO class.
 */
public class PerformanceDAOTest {
	private PerformanceDAO performanceDAO;

	@BeforeEach
	public void setUp() {
		// Initialise the PerformanceDAO instance before each test
		performanceDAO = new PerformanceDAO();
	}

	/**
	 * Test retrieving performances by show ID.
	 */
	@Test
	public void testGetPerformancesByShowId() {
		try {
			// Retrieve performances by show ID
			List<Performance> performances = performanceDAO.getPerformancesByShowId(1);

			// Verify that the list of performances is not null
			assertNotNull(performances);

			// Verify that the list of performances is not empty
			assertFalse(performances.isEmpty());

			// Verify that each performance in the list has the correct show ID
			for (Performance performance : performances) {
				assertEquals(1, performance.getShowId());
			}
		} catch (SQLException e) {
			// If an SQL exception occurs, the test fails
			fail("SQL exception: " + e.getMessage());
		}
	}

	/**
	 * Test retrieving performances by date.
	 */
	@Test
	public void testGetPerformancesByDate() {
		try {
			// Define the date to search for performances
			Date date = Date.valueOf("2023-07-15");

			// Retrieve performances by date
			List<Performance> performances = performanceDAO.getPerformancesByDate(date);

			// Verify that the list of performances is not null
			assertNotNull(performances);

			// Verify that the list of performances is not empty
			assertFalse(performances.isEmpty());

			// Verify that each performance in the list has the correct date
			for (Performance performance : performances) {
				assertEquals(date, performance.getDate());
			}
		} catch (SQLException e) {
			// If an SQL exception occurs, the test fails
			fail("SQL exception: " + e.getMessage());
		}
	}
}
