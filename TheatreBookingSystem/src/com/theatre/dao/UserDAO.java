package com.theatre.dao;

import java.sql.*;

import com.theatre.model.User;
import com.theatre.util.DatabaseUtil;
import com.theatre.util.EncryptionUtil;

/**
 * Data Access Object (DAO) class for managing User entities.
 */
public class UserDAO {

	/**
	 * Saves a user to the database.
	 * 
	 * @param user The user to be saved.
	 * @throws SQLException If a database access error occurs.
	 */
	public void saveUser(User user) throws SQLException {
		String query = "INSERT INTO users (name, address, credit_card_number) VALUES (?, ?, ?)";

		// Establish a connection, prepare the statement, and execute the update
		try (Connection conn = DatabaseUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

			// Set the parameters for the prepared statement
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getAddress());
			try {
				pstmt.setString(3, EncryptionUtil.encrypt(user.getCreditCard()));
			} catch (Exception e) {
				throw new SQLException("Error encrypting credit card number", e);
			}
			pstmt.executeUpdate();

			// Retrieve the generated key (user ID) and set it to the user
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				if (rs.next()) {
					user.setId(rs.getInt(1));
				}
			}
		}
	}

	/**
	 * Retrieves a user by their ID.
	 * 
	 * @param id The ID of the user to retrieve.
	 * @return The user with the specified ID, or null if no user is found.
	 * @throws SQLException If a database access error occurs.
	 */
	public User getUserById(int id) throws SQLException {
		String query = "SELECT * FROM users WHERE id = ?";
		User user = null;

		// Establish a connection, prepare the statement, and execute the query
		try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					user = mapRowToUser(rs);
				}
			}
		}

		return user;
	}

	/**
	 * Maps a row from the ResultSet to a User object.
	 * 
	 * @param rs The ResultSet containing the user data.
	 * @return A User object populated with the data from the ResultSet.
	 * @throws SQLException If an SQL error occurs while accessing the ResultSet.
	 */
	private User mapRowToUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setAddress(rs.getString("address"));
		try {
			user.setCreditCard(EncryptionUtil.decrypt(rs.getString("credit_card_number")));
		} catch (Exception e) {
			throw new SQLException("Error decrypting credit card number", e);
		}
		return user;
	}
}
