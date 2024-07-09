package com.theatre.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.theatre.ui.InputReader;

/**
 * Unit tests for the InputReader class.
 */
class InputReaderTest {

	@BeforeEach
	void setUp() throws Exception {
		// Setup code if needed
	}

	@AfterEach
	void tearDown() throws Exception {
		// Tear down code if needed
	}

	/**
	 * Test the getString method.
	 */
	@Test
	public void testGetString() {
		// Simulate input for the test
		String input = "I am looking for Stormzy Concert\nWhat's the price for this show?\n";
		ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
		InputReader.setScanner(testIn);

		// Test getString method
		String text = InputReader.getString("Enter some text: ");
		assertEquals("I am looking for Stormzy Concert", text);

		// Test getString method again with the next input line
		text = InputReader.getString("Enter some text: ");
		assertEquals("What's the price for this show?", text);
	}

	/**
	 * Test the getInt method.
	 */
	@Test
	public void testGetInt() {
		// Simulate input for the test
		String input = "4\n2\n";
		ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
		InputReader.setScanner(testIn);

		// Test getInt method
		int number = InputReader.getInt("Enter a number: ");
		assertEquals(4, number);

		// Test getInt method again with the next input line
		number = InputReader.getInt("Enter a number: ");
		assertEquals(2, number);
	}

	/**
	 * Test the getMixedInput method for mixed inputs.
	 */
	@Test
	public void testGetMixedInput() {
		// Simulate mixed input for the test
		String input = "7\nThe Stormzy Concert is sold out\n-4\nWhat's your next available performance of Tosca?\n";
		ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
		InputReader.setScanner(testIn);

		// Test getInt method
		int number = InputReader.getInt("Enter a number: ");
		assertEquals(7, number);

		// Test getString method
		String text = InputReader.getString("Enter some text: ");
		assertEquals("The Stormzy Concert is sold out", text);

		// Test getInt method with a negative number
		number = InputReader.getInt("Enter a number: ");
		assertEquals(-4, number);

		// Test getString method again with the next input line
		text = InputReader.getString("Enter some text: ");
		assertEquals("What's your next available performance of Tosca?", text);
	}
}
