package com.theatre.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.theatre.dao.ShowDAO;
import com.theatre.model.Show;

/**
 * Unit tests for the ShowDAO class.
 */
public class ShowDAOTest {
	private ShowDAO showDAO;

	@BeforeEach
	public void setUp() {
		// Initialise the ShowDAO instance before each test
		showDAO = new ShowDAO();
	}

	/**
	 * Test retrieving all shows from the database.
	 */
	@Test
	public void testGetAllShows() {
		try {
			// Retrieve all shows
			List<Show> shows = showDAO.getAllShows();

			// Verify that the list of shows is not null
			assertNotNull(shows, "The list of shows should not be null");

			// Verify that the list of shows is not empty
			assertFalse(shows.isEmpty(), "The list of shows should not be empty");

			// Optionally, verify some properties of the retrieved shows
			for (Show show : shows) {
				assertNotNull(show.getTitle(), "Show title should not be null");
				assertNotNull(show.getType(), "Show type should not be null");
				// Add more assertions as needed
			}
		} catch (SQLException e) {
			// If an SQL exception occurs, the test fails
			fail("SQL exception: " + e.getMessage());
		}
	}
}
