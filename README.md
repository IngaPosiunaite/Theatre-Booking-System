# Theatre Booking System

## Table of Contents
1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Technical Details](#technical-details)
4. [Database Schema](#database-schema)
5. [Sample Data](#sample-data)
6. [Installation and Setup](#installation-and-setup)
7. [Class Diagram](#class-diagram)
8. [EER Diagram](#eer-diagram)
9. [Testing](#testing)
10. [Usage](#usage)
11. [Development Phases](#development-phases)

## Project Overview
The Theatre Booking System is a console-based application designed to manage theatre show bookings. It provides functionalities for browsing shows, searching performances by date, and purchasing tickets. The system is split into different user interfaces for theatre employees and the general public, enabling efficient management and booking of theatre performances.

## Features

- **Show Management**: Manage information about various shows, including titles, types (theatre, musical, opera, concert), descriptions, languages, and principal performers.
- **Performance Scheduling**: Schedule multiple performances for each show, specifying dates, times, durations, prices, and ticket availability.
- **Ticket Booking**: Allow users to browse available shows and performances, search for specific dates, and purchase tickets. The system ensures that seats are not double-booked.
- **User Management**: Store and manage user information, including encrypted credit card details for secure transactions.
- **Discounts**: Offer concessionary tickets at a discount for eligible users.
- **Secure Transactions**: Implement encryption for sensitive user information, such as credit card numbers.

## Technical Details

- **Programming Language**: Java
- **Database**: MySQL
- **Encryption**: AES/CBC/PKCS5Padding for secure storage of credit card information
- **Project Structure**: The project is organized into five packages:
  - `com.theatre.model`: Contains data models for the application (User, Show, Performance, Ticket).
  - `com.theatre.dao`: Data Access Objects (DAO) for database interactions.
  - `com.theatre.services`: Service layer classes for business logic.
  - `com.theatre.ui`: Console-based user interface components.
  - `com.theatre.util`: Utility classes, including database connection and encryption utilities.

## Database Schema

The database schema includes the following tables:

- **users**: Stores user information (id, name, address, credit card number).
- **shows**: Stores show information (id, title, type, description, language, live music, principal performers).
- **performances**: Stores performance information (id, show_id, date, time, duration, price, available tickets).
- **tickets**: Stores ticket information (id, performance_id, user_id, seat type, is_concessionary).

## Sample Data

The database is pre-populated with sample data for testing and demonstration purposes, including users, shows, performances, and tickets.

## Installation and Setup
1. Clone the repository:

```
git clone https://github.com/IngaPosiunaite/Theatre-Booking-System.git
cd theatre-booking-system
```
2. Set Up the Database:
Ensure MySQL is installed and running. Run the provided theatre_database.sql script to set up the database schema and sample data.

```
SOURCE /path/to/theatre_database.sql;
```
3. Configure the Application:
Update the database connection settings in the 'DatabaseUtil' class if necessary.

4. Compile and Run:
Use your preferred IDE (e.g., Eclipse) to compile and run the application.

## Class Diagram
Below is the Class Diagram for the relationship among different classes. The diagram illustrates the primary classes involved in the system and their interactions. Each class is part of a specific package (model, dao, services, ui, util), and the relationships between them are depicted to showcase dependencies and interactions.

![f81751e0-87db-4250-b072-8732f2251028](https://github.com/IngaPosiunaite/Hangman/assets/119749457/c6556d26-34ce-45b3-9eea-3855116eeed8)

## EER Diagram
Below is the Entity-Relationship Diagram (ERD) for the theatre database. The diagram illustrates the tables in the database and their relationships. Each table corresponds to a key entity in the system (users, shows, performances, tickets), and the relationships between these tables are shown to clarify how they interact and connect.

![Screenshot 2024-07-09 085406](https://github.com/IngaPosiunaite/Hangman/assets/119749457/23233c8a-a7ae-4ab2-8e8f-c50047527ffb)


## Testing
The project includes unit tests to ensure the correctness and reliability of the codebase. Tests are written for various components including the data models, services, and utilities.

1. Run Tests:
You can run the tests using your IDE's built-in test runner or a command-line tool like Maven or Gradle if configured.

2. Sample Test Cases:
- **User Service Tests**: Ensure user information is correctly saved and retrieved.
- **Show Service Tests**: Verify that show details are accurately managed.
- **Performance Service Tests**: Check the scheduling and retrieval of performances.
- **Ticket Service Tests**: Confirm the booking process and ticket management.

## Usage
- **Browse Shows**: View details of all available shows.
- **Search by Date**: Find performances by a specific date.
- **Purchase Tickets**: Select performances and purchase tickets by providing user details and payment information.

## Development Phases
Scoping and Organizing:

- **Initial briefing and client meeting to clarify requirements**.
- **Team organization and task allocation**.

Development and Testing:

- **Daily scrum meetings and continuous development**.
- **Emphasis on writing tests before code implementation**.

Final Development and Preparation:

- **Complete remaining tasks and prepare for final presentation**.
- **Ensure all deliverables are ready for submission**.

Demonstration and Retrospective:

- **Final presentation and demonstration of the project**.
- **Submission of all required documents and source code**.

This project adheres to the guidelines for good practice, including clear and well-structured code, meaningful variable names, appropriate comments, and unit tests to ensure quality and reliability.

