package com.theatre.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.theatre.model.Show;
import com.theatre.util.DatabaseUtil;

/**
 * Data Access Object (DAO) class for managing Show entities.
 */
public class ShowDAO {

	/**
	 * Retrieves a list of all shows from the database.
	 * 
	 * @return A list of all shows.
	 * @throws SQLException If a database access error occurs.
	 */
	public List<Show> getAllShows() throws SQLException {
		List<Show> shows = new ArrayList<>();
		String query = "SELECT * FROM shows";

		// Establish a connection, create a statement, and execute the query
		try (Connection conn = DatabaseUtil.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {

			// Iterate through the result set and map each row to a Show object
			while (rs.next()) {
				shows.add(mapRowToShow(rs));
			}
		}

		return shows;
	}

	/**
	 * Maps a row from the ResultSet to a Show object.
	 * 
	 * @param rs The ResultSet containing the show data.
	 * @return A Show object populated with the data from the ResultSet.
	 * @throws SQLException If an SQL error occurs while accessing the ResultSet.
	 */
	private Show mapRowToShow(ResultSet rs) throws SQLException {
		Show show = new Show();
		show.setId(rs.getInt("id"));
		show.setTitle(rs.getString("title"));
		show.setType(rs.getString("type"));
		show.setDescription(rs.getString("description"));
		show.setLanguage(rs.getString("language"));
		show.setLiveMusic(rs.getBoolean("live_music"));
		show.setPrincipalPerformers(rs.getString("principal_performers"));
		return show;
	}
}
