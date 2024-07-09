package com.theatre.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.theatre.dao.ShowDAO;
import com.theatre.model.Show;
import com.theatre.services.ShowService;

/**
 * Unit tests for the ShowService class.
 */
public class ShowServiceTest {
    private ShowService showService;

    @BeforeEach
    public void setUp() {
        // Initialise the ShowService instance with a stubbed ShowDAO
        showService = new ShowService(new StubShowDAO());
    }

    /**
     * Test retrieving all shows.
     */
    @Test
    public void testGetAllShows() {
        try {
            // Retrieve all shows
            List<Show> shows = showService.getAllShows();

            // Verify that the list of shows is not null
            assertNotNull(shows, "The list of shows should not be null");

            // Verify that the list of shows is not empty
            assertFalse(shows.isEmpty(), "The list of shows should not be empty");
        } catch (SQLException e) {
            // If an SQL exception occurs, the test fails
            fail("SQL exception: " + e.getMessage());
        }
    }

    /**
     * Stub implementation of ShowDAO for testing purposes.
     */
    private class StubShowDAO extends ShowDAO {
        @Override
        public List<Show> getAllShows() throws SQLException {
            // Return a stubbed list of shows for testing
            List<Show> shows = new ArrayList<>();
            Show show = new Show();
            show.setId(1);
            show.setTitle("Mock Show");
            show.setType("Theatre");
            show.setDescription("A mock show for testing.");
            show.setLanguage("English");
            show.setLiveMusic(true);
            show.setPrincipalPerformers("John Doe");
            shows.add(show);
            return shows;
        }
    }
}
