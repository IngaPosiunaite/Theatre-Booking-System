package com.theatre.ui;

import java.sql.SQLException;
import java.util.List;

import com.theatre.model.*;
import com.theatre.services.*;

import java.sql.Date;

/**
 * TheatreUI class provides a console-based user interface for the Theatre Royal
 * Booking System. Users can browse shows, search for shows by date, and
 * purchase tickets.
 */
public class TheatreUI {
	// Service instances to interact with business logic
	private static ShowService showService = new ShowService();
	private static PerformanceService performanceService = new PerformanceService();
	private static UserService userService = new UserService();
	private static TicketService ticketService = new TicketService();

	public static void main(String[] args) {
		boolean exit = false;

		while (!exit) {
			// Display the main menu
			System.out.println("Welcome to Theatre Royal Booking System");
			System.out.println("1. Browse Shows");
			System.out.println("2. Search Show by Date");
			System.out.println("3. Purchase Tickets");
			System.out.println("4. Exit");

			// Get user's choice
			int choice = InputReader.getInt("Select an option: ");

			// Handle the user's choice
			switch (choice) {
			case 1:
				browseShows();
				break;
			case 2:
				searchShowByDate();
				break;
			case 3:
				purchaseTickets();
				break;
			case 4:
				exit = true;
				break;
			default:
				System.out.println("Invalid choice, please try again.");
			}
		}
	}

	/**
	 * Browse and display all available shows.
	 */
	private static void browseShows() {
		try {
			// Retrieve all shows using ShowService
			List<Show> shows = showService.getAllShows();
			// Display each show
			for (Show show : shows) {
				System.out.println(show);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Search and display performances by a specific date.
	 */
	private static void searchShowByDate() {
		// Get date input from user
		String dateInput = InputReader.getString("Enter date (yyyy-mm-dd): ");
		Date date = Date.valueOf(dateInput);

		try {
			// Retrieve performances by date using PerformanceService
			List<Performance> performances = performanceService.getPerformancesByDate(date);
			// Display each performance
			for (Performance performance : performances) {
				System.out.println(performance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Facilitate the process of purchasing tickets.
	 */
	private static void purchaseTickets() {
		try {
			// Display available shows and performances
			browseShows();
			int showId = InputReader.getInt("Enter the show ID to see its performances: ");

			// Retrieve performances for the selected show using PerformanceService
			List<Performance> performances = performanceService.getPerformancesByShowId(showId);
			// Display each performance
			for (Performance performance : performances) {
				System.out.println(performance);
			}

			// Get performance ID and number of tickets from user
			int performanceId = InputReader.getInt("Enter the performance ID to purchase tickets: ");
			int numTickets = InputReader.getInt("Enter number of tickets: ");

			// Collect user details
			User user = new User();
			user.setName(InputReader.getString("Enter your name: "));
			user.setAddress(InputReader.getString("Enter your address: "));
			user.setCreditCard(InputReader.getString("Enter your credit card number: "));

			// Save user details using UserService
			userService.saveUser(user);

			// Collect and save ticket details
			for (int i = 0; i < numTickets; i++) {
				Ticket ticket = new Ticket();
				ticket.setPerformanceId(performanceId);
				ticket.setSeatType(InputReader.getString("Enter seat type (stalls/circle): "));
				ticket.setConcessionary(InputReader.getBoolean("Is this a concessionary ticket?"));

				// Save ticket details using TicketService
				ticketService.saveTicket(ticket);
			}

			// Confirm ticket purchase
			System.out.println("Tickets purchased successfully!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
