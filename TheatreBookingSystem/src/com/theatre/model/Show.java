package com.theatre.model;

/**
 * Model class representing a show.
 */
public class Show {
	private int id; // Unique identifier for the show
	private String title; // Title of the show
	private String type; // Type of the show (e.g., theatre, musical, opera, concert)
	private String description; // Description of the show
	private String language; // Language of the show
	private boolean liveMusic; // Indicates if the show includes live music
	private String principalPerformers; // Names of the principal performers or performing group

	// Getters and setters

	/**
	 * Gets the unique identifier for the show.
	 * 
	 * @return The show ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the unique identifier for the show.
	 * 
	 * @param id The show ID.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the title of the show.
	 * 
	 * @return The show title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the show.
	 * 
	 * @param title The show title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the type of the show.
	 * 
	 * @return The show type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of the show.
	 * 
	 * @param type The show type.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the description of the show.
	 * 
	 * @return The show description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of the show.
	 * 
	 * @param description The show description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the language of the show.
	 * 
	 * @return The show language.
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language of the show.
	 * 
	 * @param language The show language.
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Checks if the show includes live music.
	 * 
	 * @return True if the show includes live music, otherwise false.
	 */
	public boolean isLiveMusic() {
		return liveMusic;
	}

	/**
	 * Sets whether the show includes live music.
	 * 
	 * @param liveMusic True if the show includes live music, otherwise false.
	 */
	public void setLiveMusic(boolean liveMusic) {
		this.liveMusic = liveMusic;
	}

	/**
	 * Gets the names of the principal performers or performing group.
	 * 
	 * @return The principal performers.
	 */
	public String getPrincipalPerformers() {
		return principalPerformers;
	}

	/**
	 * Sets the names of the principal performers or performing group.
	 * 
	 * @param principalPerformers The principal performers.
	 */
	public void setPrincipalPerformers(String principalPerformers) {
		this.principalPerformers = principalPerformers;
	}

	/**
	 * Returns a string representation of the show.
	 * 
	 * @return A string containing show details.
	 */
	@Override
	public String toString() {
		return "Show{" + "id=" + id + ", title='" + title + '\'' + ", type='" + type + '\'' + ", description='"
				+ description + '\'' + ", language='" + language + '\'' + ", liveMusic=" + liveMusic
				+ ", principalPerformers='" + principalPerformers + '\'' + '}';
	}
}
