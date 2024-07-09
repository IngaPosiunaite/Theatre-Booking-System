-- Drop the database if it exists
DROP DATABASE IF EXISTS theatre_database;

-- Create the database
CREATE DATABASE theatre_database;
USE theatre_database;

-- Create the users table
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Unique identifier for the user
    name VARCHAR(100) NOT NULL, -- Name of the user
    address VARCHAR(255) NOT NULL, -- Address of the user
    credit_card_number VARCHAR(255) NOT NULL -- Encrypted credit card number of the user
);

-- Create the shows table
CREATE TABLE shows (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Unique identifier for the show
    title VARCHAR(100) NOT NULL, -- Title of the show
    type ENUM('theatre', 'musical', 'opera', 'concert') NOT NULL, -- Type of the show
    description TEXT NOT NULL, -- Description of the show
    language VARCHAR(50), -- Language of the show (NULL if not applicable)
    live_music BOOLEAN NOT NULL, -- Indicates if the show includes live music
    principal_performers VARCHAR(255) -- Names of the principal performers or performing group
);

-- Create the performances table
CREATE TABLE performances (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Unique identifier for the performance
    show_id INT NOT NULL, -- Identifier for the associated show
    date DATE NOT NULL, -- Date of the performance
    time TIME NOT NULL, -- Time of the performance
    duration INT NOT NULL, -- Duration of the performance in minutes
    price DECIMAL(10, 2) NOT NULL, -- Price of the tickets for the performance
    available_tickets INT NOT NULL, -- Number of available tickets for the performance
    FOREIGN KEY (show_id) REFERENCES shows(id) -- Foreign key constraint referencing the shows table
);

-- Create the tickets table
CREATE TABLE tickets (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Unique identifier for the ticket
    performance_id INT NOT NULL, -- Identifier for the associated performance
    user_id INT NOT NULL, -- Identifier for the associated user
    seat_type ENUM('stalls', 'circle') NOT NULL, -- Type of seat
    is_concessionary BOOLEAN NOT NULL, -- Indicates if the ticket is concessionary
    FOREIGN KEY (performance_id) REFERENCES performances(id), -- Foreign key constraint referencing the performances table
    FOREIGN KEY (user_id) REFERENCES users(id) -- Foreign key constraint referencing the users table
);

-- Sample data for users
INSERT INTO users (name, address, credit_card_number) VALUES
('John Doe', '123 Main St', 'EncryptedCreditCard123'),
('Jane Smith', '456 Oak St', 'EncryptedCreditCard456');

-- Sample data for shows
INSERT INTO shows (title, type, description, language, live_music, principal_performers) VALUES
('The Phantom of the Opera', 'musical', 'A thrilling musical journey.', 'English', TRUE, 'John Doe'),
('Swan Lake', 'opera', 'A beautiful opera performance.', 'Russian', TRUE, 'Maria Ivanova');

-- Sample data for performances
INSERT INTO performances (show_id, date, time, duration, price, available_tickets) VALUES
(1, '2024-08-01', '19:00:00', 150, 100.00, 200),
(1, '2024-08-02', '14:00:00', 150, 80.00, 200),
(2, '2024-08-01', '20:00:00', 120, 120.00, 200);

-- Sample data for tickets
INSERT INTO tickets (performance_id, user_id, seat_type, is_concessionary) VALUES
(1, 1, 'stalls', FALSE),
(1, 2, 'circle', TRUE),
(2, 1, 'stalls', FALSE);
