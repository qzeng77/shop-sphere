-- Clear existing data
DELETE FROM payment_methods;
DELETE FROM addresses;
DELETE FROM users;

-- Insert test users first
INSERT INTO users (email, username, password)
VALUES
('john.doe@example.com', 'johndoe', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG'),
('jane.smith@example.com', 'janesmith', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG');

-- Wait a second before inserting related data (helps with timing issues)
SET @john_id = (SELECT id FROM users WHERE email = 'john.doe@example.com');
SET @jane_id = (SELECT id FROM users WHERE email = 'jane.smith@example.com');

-- Insert addresses using variables
INSERT INTO addresses (user_id, street, city, state, country, zip_code)
VALUES
(@john_id, '123 Main St', 'New York', 'NY', 'USA', '10001'),
(@jane_id, '456 Park Ave', 'Los Angeles', 'CA', 'USA', '90001');

-- Insert payment methods using variables
INSERT INTO payment_methods (user_id, card_number, card_holder_name, expiration_date)
VALUES
(@john_id, '4111111111111111', 'John Doe', '12/25'),
(@jane_id, '5555555555554444', 'Jane Smith', '03/25');