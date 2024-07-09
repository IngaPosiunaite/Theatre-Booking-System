package com.theatre.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for managing database connections.
 */
public class DatabaseUtil {
	// Database connection parameters
	private static final String URL = "jdbc:mysql://localhost:3306/theatre_royal";
	private static final String USER = "root";
	private static final String PASSWORD = "password";

	// Static block to load the MySQL JDBC driver
	static {
		try {
			// Load the MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError("Failed to load MySQL JDBC driver");
		}
	}

	/**
	 * Obtains a connection to the database.
	 * 
	 * @return A Connection object to the database.
	 * @throws SQLException If a database access error occurs.
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
