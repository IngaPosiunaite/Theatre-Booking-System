package com.theatre.services;

import java.sql.SQLException;
import java.util.List;

import com.theatre.dao.ShowDAO;
import com.theatre.model.Show;

/**
 * Service class for managing Show-related operations.
 */
public class ShowService {
    private ShowDAO showDAO;

    /**
     * Default constructor that initialises ShowDAO.
     */
    public ShowService() {
        this.showDAO = new ShowDAO();
    }

    /**
     * Constructor for dependency injection, useful for testing.
     * 
     * @param showDAO The ShowDAO instance to use.
     */
    public ShowService(ShowDAO showDAO) {
        this.showDAO = showDAO;
    }

    /**
     * Retrieves a list of all shows.
     * 
     * @return A list of all shows.
     * @throws SQLException If a database access error occurs.
     */
    public List<Show> getAllShows() throws SQLException {
        return showDAO.getAllShows();
    }
}
