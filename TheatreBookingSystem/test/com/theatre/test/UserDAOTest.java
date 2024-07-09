package com.theatre.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.theatre.dao.UserDAO;
import com.theatre.model.User;

/**
 * Unit tests for the UserDAO class.
 */
public class UserDAOTest {
	private UserDAO userDAO;

	@BeforeEach
	public void setUp() {
		// Initialise the UserDAO instance before each test
		userDAO = new UserDAO();
	}

	/**
	 * Test saving a user to the database.
	 */
	@Test
	public void testSaveUser() {
		// Create a new User instance
		User user = new User();
		user.setName("Jane Doe");
		user.setAddress("456 Main St");
		user.setCreditCard("4111111111111111");

		try {
			// Save the user to the database
			userDAO.saveUser(user);

			// Verify that the user ID is not null after saving
			assertNotNull(user.getId(), "The user ID should not be null after saving");
		} catch (SQLException e) {
			// If an SQL exception occurs, the test fails
			fail("SQL exception: " + e.getMessage());
		}
	}

	/**
	 * Test retrieving a user by ID from the database.
	 */
	@Test
	public void testGetUserById() {
		try {
			// Retrieve the user by ID
			User user = userDAO.getUserById(1);

			// Verify that the user is not null
			assertNotNull(user, "The user should not be null");

			// Verify that the user ID is correct
			assertEquals(1, user.getId(), "The user ID should be 1");

			// Verify that the user's details are correct
			assertEquals("Jane Doe", user.getName(), "The user name should be 'Jane Doe'");
			assertEquals("456 Main St", user.getAddress(), "The user address should be '456 Main St'");
			assertEquals("4111111111111111", user.getCreditCard(), "The user credit card should be '4111111111111111'");
		} catch (SQLException e) {
			// If an SQL exception occurs, the test fails
			fail("SQL exception: " + e.getMessage());
		}
	}
}
