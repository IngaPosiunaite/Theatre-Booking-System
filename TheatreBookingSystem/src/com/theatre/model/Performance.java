package com.theatre.model;

import java.time.LocalTime;
import java.util.Date;

/**
 * Model class representing a performance.
 */
public class Performance {
	private int id; // Unique identifier for the performance
	private int showId; // Identifier for the associated show
	private Date date; // Date of the performance
	private LocalTime time; // Time of the performance
	private int duration; // Duration of the performance in minutes
	private double price; // Price of the tickets for the performance
	private int availableTickets; // Number of available tickets for the performance

	// Getters and setters

	/**
	 * Gets the unique identifier for the performance.
	 * 
	 * @return The performance ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the unique identifier for the performance.
	 * 
	 * @param id The performance ID.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the identifier for the associated show.
	 * 
	 * @return The show ID.
	 */
	public int getShowId() {
		return showId;
	}

	/**
	 * Sets the identifier for the associated show.
	 * 
	 * @param showId The show ID.
	 */
	public void setShowId(int showId) {
		this.showId = showId;
	}

	/**
	 * Gets the date of the performance.
	 * 
	 * @return The performance date.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date of the performance.
	 * 
	 * @param date The performance date.
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the time of the performance.
	 * 
	 * @return The performance time.
	 */
	public LocalTime getTime() {
		return time;
	}

	/**
	 * Sets the time of the performance.
	 * 
	 * @param time The performance time.
	 */
	public void setTime(LocalTime time) {
		this.time = time;
	}

	/**
	 * Gets the duration of the performance in minutes.
	 * 
	 * @return The performance duration.
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Sets the duration of the performance in minutes.
	 * 
	 * @param duration The performance duration.
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Gets the price of the tickets for the performance.
	 * 
	 * @return The ticket price.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price of the tickets for the performance.
	 * 
	 * @param price The ticket price.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets the number of available tickets for the performance.
	 * 
	 * @return The number of available tickets.
	 */
	public int getAvailableTickets() {
		return availableTickets;
	}

	/**
	 * Sets the number of available tickets for the performance.
	 * 
	 * @param availableTickets The number of available tickets.
	 */
	public void setAvailableTickets(int availableTickets) {
		this.availableTickets = availableTickets;
	}

	/**
	 * Returns a string representation of the performance.
	 * 
	 * @return A string containing performance details.
	 */
	@Override
	public String toString() {
		return "Performance{" + "id=" + id + ", showId=" + showId + ", date=" + date + ", time=" + time + ", duration="
				+ duration + ", price=" + price + ", availableTickets=" + availableTickets + '}';
	}
}
