package com.theatre.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.theatre.model.Performance;

/**
 * Unit tests for the Performance class.
 */
public class PerformanceTest {
	private Performance performance;

	@BeforeEach
	public void setUp() {
		// Initialise a new Performance instance before each test
		performance = new Performance();
	}

	/**
	 * Test the getters and setters of the Performance class.
	 */
	@Test
	public void testPerformanceSettersAndGetters() {
		// Set values for the Performance instance
		performance.setId(1);
		performance.setShowId(1);
		performance.setDate(new Date());
		performance.setTime(LocalTime.of(19, 0));
		performance.setDuration(120);
		performance.setPrice(50.0);
		performance.setAvailableTickets(200);

		// Assert that the values have been set correctly
		assertEquals(1, performance.getId());
		assertEquals(1, performance.getShowId());
		assertNotNull(performance.getDate());
		assertEquals(LocalTime.of(19, 0), performance.getTime());
		assertEquals(120, performance.getDuration());
		assertEquals(50.0, performance.getPrice());
		assertEquals(200, performance.getAvailableTickets());
	}

	/**
	 * Test the toString method of the Performance class.
	 */
	@Test
	public void testToString() {
		// Set values for the Performance instance
		performance.setId(1);
		performance.setShowId(1);
		performance.setDate(new Date());
		performance.setTime(LocalTime.of(19, 0));
		performance.setDuration(120);
		performance.setPrice(50.0);
		performance.setAvailableTickets(200);

		// Assert that the toString method returns the expected string
		String expected = "Performance{id=1, showId=1, date=" + performance.getDate()
				+ ", time=19:00, duration=120, price=50.0, availableTickets=200}";
		assertEquals(expected, performance.toString());
	}
}
