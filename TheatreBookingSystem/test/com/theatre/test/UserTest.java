package com.theatre.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.theatre.model.User;

/**
 * Unit tests for the User class.
 */
public class UserTest {
	private User user;

	@BeforeEach
	public void setUp() {
		// Initialise a new User instance before each test
		user = new User();
	}

	/**
	 * Test the getters and setters of the User class.
	 */
	@Test
	public void testUserSettersAndGetters() {
		// Set values for the User instance
		user.setId(1);
		user.setName("Jane Doe");
		user.setAddress("123 Main St");
		user.setCreditCard("4111111111111111");

		// Assert that the values have been set correctly
		assertEquals(1, user.getId());
		assertEquals("Jane Doe", user.getName());
		assertEquals("123 Main St", user.getAddress());
		assertEquals("4111111111111111", user.getCreditCard());
	}

	/**
	 * Test the toString method of the User class.
	 */
	@Test
	public void testToString() {
		// Set values for the User instance
		user.setId(1);
		user.setName("Jane Doe");
		user.setAddress("123 Main St");
		user.setCreditCard("4111111111111111");

		// Assert that the toString method returns the expected string
		String expected = "User{id=1, name='Jane Doe', address='123 Main St', creditCard='4111111111111111'}";
		assertEquals(expected, user.toString());
	}
}
