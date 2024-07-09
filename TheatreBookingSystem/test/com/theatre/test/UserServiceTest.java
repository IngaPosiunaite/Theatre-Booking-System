package com.theatre.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.theatre.dao.UserDAO;
import com.theatre.model.User;
import com.theatre.services.UserService;

/**
 * Unit tests for the UserService class.
 */
public class UserServiceTest {
	private UserService userService;

	@BeforeEach
	public void setUp() {
		// Initialise the UserService instance with a stubbed UserDAO
		userService = new UserService(new StubUserDAO());
	}

	/**
	 * Test saving a user.
	 */
	@Test
	public void testSaveUser() {
		// Create a new User instance
		User user = new User();
		user.setName("Jane Doe");
		user.setAddress("456 Main St");
		user.setCreditCard("4111111111111111");

		try {
			// Save the user using the service
			userService.saveUser(user);

			// Verify that the user ID is not null after saving
			assertNotNull(user.getId(), "The user ID should not be null after saving");
		} catch (SQLException e) {
			// If an SQL exception occurs, the test fails
			fail("SQL exception: " + e.getMessage());
		}
	}

	/**
	 * Stub implementation of UserDAO for testing purposes.
	 */
	private class StubUserDAO extends UserDAO {
		@Override
		public void saveUser(User user) throws SQLException {
			// Simulate saving the user by setting a mock ID
			user.setId(1);
		}
	}
}
