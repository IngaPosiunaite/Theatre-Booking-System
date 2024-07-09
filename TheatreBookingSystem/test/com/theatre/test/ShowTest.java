package com.theatre.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.theatre.model.Show;

/**
 * Unit tests for the Show class.
 */
public class ShowTest {
	private Show show;

	@BeforeEach
	public void setUp() {
		// Initialise a new Show instance before each test
		show = new Show();
	}

	/**
	 * Test the getters and setters of the Show class.
	 */
	@Test
	public void testShowSettersAndGetters() {
		// Set values for the Show instance
		show.setId(1);
		show.setTitle("Phantom of the Opera");
		show.setType("Musical");
		show.setDescription("A thrilling musical journey.");
		show.setLanguage("English");
		show.setLiveMusic(true);
		show.setPrincipalPerformers("John Doe");

		// Assert that the values have been set correctly
		assertEquals(1, show.getId());
		assertEquals("Phantom of the Opera", show.getTitle());
		assertEquals("Musical", show.getType());
		assertEquals("A thrilling musical journey.", show.getDescription());
		assertEquals("English", show.getLanguage());
		assertTrue(show.isLiveMusic());
		assertEquals("John Doe", show.getPrincipalPerformers());
	}

	/**
	 * Test the toString method of the Show class.
	 */
	@Test
	public void testToString() {
		// Set values for the Show instance
		show.setId(1);
		show.setTitle("Phantom of the Opera");
		show.setType("Musical");
		show.setDescription("A thrilling musical journey.");
		show.setLanguage("English");
		show.setLiveMusic(true);
		show.setPrincipalPerformers("John Doe");

		// Assert that the toString method returns the expected string
		String expected = "Show{id=1, title='Phantom of the Opera', type='Musical', description='A thrilling musical journey.', language='English', liveMusic=true, principalPerformers='John Doe'}";
		assertEquals(expected, show.toString());
	}
}
