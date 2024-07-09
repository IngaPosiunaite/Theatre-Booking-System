# Theatre Booking System

## Project Overview
The Theatre Booking System is a console-based application designed to manage theatre show bookings. It provides functionalities for browsing shows, searching performances by date, and purchasing tickets. The system is split into different user interfaces for theatre employees and the general public, enabling efficient management and booking of theatre performances.

## Features

- **Show Management**: Manage information about various shows, including titles, types (theatre, musical, opera, concert), descriptions, languages, and principal performers.
- **Performance Scheduling**: Schedule multiple performances for each show, specifying dates, times, durations, prices, and ticket availability.
- **Ticket Booking**: Allow users to browse available shows and performances, search for specific dates, and purchase tickets. The system ensures that seats are not double-booked.
- **User Management**: Store and manage user information, including encrypted credit card details for secure transactions.
- **Discounts**: Offer concessionary tickets at a 25% discount for eligible users (children under 16, students, etc.).
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
