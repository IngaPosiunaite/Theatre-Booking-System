package com.theatre.model;

/**
 * Model class representing a user.
 */
public class User {
	private int id; // Unique identifier for the user
	private String name; // Name of the user
	private String address; // Address of the user
	private String creditCard; // Credit card number of the user

	// Getters and setters

	/**
	 * Gets the unique identifier for the user.
	 * 
	 * @return The user ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the unique identifier for the user.
	 * 
	 * @param id The user ID.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name of the user.
	 * 
	 * @return The user's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the user.
	 * 
	 * @param name The user's name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the address of the user.
	 * 
	 * @return The user's address.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address of the user.
	 * 
	 * @param address The user's address.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the credit card number of the user.
	 * 
	 * @return The user's credit card number.
	 */
	public String getCreditCard() {
		return creditCard;
	}

	/**
	 * Sets the credit card number of the user.
	 * 
	 * @param creditCard The user's credit card number.
	 */
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	/**
	 * Returns a string representation of the user.
	 * 
	 * @return A string containing user details.
	 */
	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name='" + name + '\'' + ", address='" + address + '\'' + ", creditCard='"
				+ creditCard + '\'' + '}';
	}
}
