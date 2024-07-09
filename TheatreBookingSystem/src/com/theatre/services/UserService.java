package com.theatre.services;

import java.sql.SQLException;

import com.theatre.dao.UserDAO;
import com.theatre.model.User;

/**
 * Service class for managing User-related operations.
 */
public class UserService {
	private UserDAO userDAO;

	/**
	 * Default constructor that initialises UserDAO.
	 */
	public UserService() {
		this.userDAO = new UserDAO();
	}

	/**
	 * Constructor for dependency injection, useful for testing.
	 * 
	 * @param userDAO The UserDAO instance to use.
	 */
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * Saves a user.
	 * 
	 * @param user The user to be saved.
	 * @throws SQLException If a database access error occurs.
	 */
	public void saveUser(User user) throws SQLException {
		userDAO.saveUser(user);
	}
}
