package com.theatre.ui;

import java.io.InputStream;
import java.util.Scanner;

/**
 * InputReader class provides methods to read various types of input from the
 * user.
 */
public class InputReader {
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Method to get a string with a prompt.
	 * 
	 * @param prompt The message to display to the user.
	 * @return The input string entered by the user.
	 */
	public static String getString(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine();
	}

	/**
	 * Method to get an integer with a prompt.
	 * 
	 * @param prompt The message to display to the user.
	 * @return The input integer entered by the user.
	 */
	public static int getInt(String prompt) {
		System.out.print(prompt);
		while (!scanner.hasNextInt()) {
			System.out.print("Invalid input. Please enter a valid integer: ");
			scanner.next();
		}
		int value = scanner.nextInt();
		scanner.nextLine(); // Consume newline left-over
		return value;
	}

	/**
	 * Method to get a double with a prompt.
	 * 
	 * @param prompt The message to display to the user.
	 * @return The input double entered by the user.
	 */
	public static double getDouble(String prompt) {
		System.out.print(prompt);
		while (!scanner.hasNextDouble()) {
			System.out.print("Invalid input. Please enter a valid number: ");
			scanner.next();
		}
		double value = scanner.nextDouble();
		scanner.nextLine(); // Consume newline left-over
		return value;
	}

	/**
	 * Method to get a boolean with a prompt (yes/no).
	 * 
	 * @param prompt The message to display to the user.
	 * @return The input boolean entered by the user (true for "yes", false for
	 *         "no").
	 */
	public static boolean getBoolean(String prompt) {
		System.out.print(prompt + " (yes/no): ");
		while (true) {
			String input = scanner.nextLine().trim().toLowerCase();
			if (input.equals("yes")) {
				return true;
			} else if (input.equals("no")) {
				return false;
			} else {
				System.out.print("Invalid input. Please enter 'yes' or 'no': ");
			}
		}
	}

	/**
	 * Method to set the scanner for testing purposes.
	 * 
	 * @param inputStream The input stream to set for the scanner.
	 */
	public static void setScanner(InputStream inputStream) {
		scanner = new Scanner(inputStream);
	}
}
