package com.theatre.model;

/**
 * Model class representing a ticket.
 */
public class Ticket {
	private int id; // Unique identifier for the ticket
	private int performanceId; // Identifier for the associated performance
	private String seatType; // Type of seat (e.g., stalls, circle)
	private boolean concessionary; // Indicates if the ticket is concessionary

	// Getters and setters

	/**
	 * Gets the unique identifier for the ticket.
	 * 
	 * @return The ticket ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the unique identifier for the ticket.
	 * 
	 * @param id The ticket ID.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the identifier for the associated performance.
	 * 
	 * @return The performance ID.
	 */
	public int getPerformanceId() {
		return performanceId;
	}

	/**
	 * Sets the identifier for the associated performance.
	 * 
	 * @param performanceId The performance ID.
	 */
	public void setPerformanceId(int performanceId) {
		this.performanceId = performanceId;
	}

	/**
	 * Gets the type of seat.
	 * 
	 * @return The seat type.
	 */
	public String getSeatType() {
		return seatType;
	}

	/**
	 * Sets the type of seat.
	 * 
	 * @param seatType The seat type.
	 */
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	/**
	 * Checks if the ticket is concessionary.
	 * 
	 * @return True if the ticket is concessionary, otherwise false.
	 */
	public boolean isConcessionary() {
		return concessionary;
	}

	/**
	 * Sets whether the ticket is concessionary.
	 * 
	 * @param concessionary True if the ticket is concessionary, otherwise false.
	 */
	public void setConcessionary(boolean concessionary) {
		this.concessionary = concessionary;
	}

	/**
	 * Returns a string representation of the ticket.
	 * 
	 * @return A string containing ticket details.
	 */
	@Override
	public String toString() {
		return "Ticket{" + "id=" + id + ", performanceId=" + performanceId + ", seatType='" + seatType + '\''
				+ ", concessionary=" + concessionary + '}';
	}
}
