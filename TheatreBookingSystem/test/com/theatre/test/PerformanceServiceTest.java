package com.theatre.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.theatre.dao.PerformanceDAO;
import com.theatre.model.Performance;
import com.theatre.services.PerformanceService;

/**
 * Unit tests for the PerformanceService class.
 */
public class PerformanceServiceTest {
	private PerformanceService performanceService;

	@BeforeEach
	public void setUp() {
		// Initialise the PerformanceService instance with a stubbed PerformanceDAO
		performanceService = new PerformanceService(new StubPerformanceDAO());
	}

	/**
	 * Test retrieving performances by show ID.
	 */
	@Test
	public void testGetPerformancesByShowId() {
		try {
			// Retrieve performances by show ID
			List<Performance> performances = performanceService.getPerformancesByShowId(1);

			// Verify that the list of performances is not null
			assertNotNull(performances, "The list of performances should not be null");

			// Verify that the list of performances is not empty
			assertFalse(performances.isEmpty(), "The list of performances should not be empty");

			// Verify that each performance in the list has the correct show ID
			for (Performance performance : performances) {
				assertEquals(1, performance.getShowId(), "The show ID should be 1");
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
			List<Performance> performances = performanceService.getPerformancesByDate(date);

			// Verify that the list of performances is not null
			assertNotNull(performances, "The list of performances should not be null");

			// Verify that the list of performances is not empty
			assertFalse(performances.isEmpty(), "The list of performances should not be empty");

			// Verify that each performance in the list has the correct date
			for (Performance performance : performances) {
				assertEquals(date, performance.getDate(), "The date should match the input date");
			}
		} catch (SQLException e) {
			// If an SQL exception occurs, the test fails
			fail("SQL exception: " + e.getMessage());
		}
	}

	/**
	 * Stub implementation of PerformanceDAO for testing purposes.
	 */
	private class StubPerformanceDAO extends PerformanceDAO {
		@Override
		public List<Performance> getPerformancesByShowId(int showId) throws SQLException {
			// Return a stubbed list of performances for testing
			List<Performance> performances = new ArrayList<>();
			Performance performance = new Performance();
			performance.setId(1);
			performance.setShowId(showId);
			performance.setDate(Date.valueOf("2023-07-15"));
			performance.setTime(java.time.LocalTime.of(19, 0));
			performance.setDuration(120);
			performance.setPrice(50.0);
			performance.setAvailableTickets(100);
			performances.add(performance);
			return performances;
		}

		@Override
		public List<Performance> getPerformancesByDate(Date date) throws SQLException {
			// Return a stubbed list of performances for testing
			List<Performance> performances = new ArrayList<>();
			Performance performance = new Performance();
			performance.setId(1);
			performance.setShowId(1);
			performance.setDate(date);
			performance.setTime(java.time.LocalTime.of(19, 0));
			performance.setDuration(120);
			performance.setPrice(50.0);
			performance.setAvailableTickets(100);
			performances.add(performance);
			return performances;
		}
	}
}
