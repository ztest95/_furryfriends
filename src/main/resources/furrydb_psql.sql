-- PostgreSQL dump
-- Host: localhost    Database: furry_friends_db
-- ------------------------------------------------------

-- Drop existing tables if they exist
DROP TABLE IF EXISTS cat;
DROP TABLE IF EXISTS dog;
DROP TABLE IF EXISTS bird;
DROP TABLE IF EXISTS hamster;
DROP TABLE IF EXISTS pet;

-- Create the pet table
CREATE TABLE pet (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  age INT NOT NULL,
  type VARCHAR(255) NOT NULL
);

-- Insert data into the pet table
INSERT INTO pet (id, name, age, type) VALUES 
(1, 'Max', 3, 'DOG'),
(2, 'Bella', 2, 'DOG'),
(3, 'Charlie', 5, 'DOG'),
(4, 'Lucy', 1, 'DOG'),
(5, 'Cooper', 4, 'DOG'),
(6, 'Luna', 2, 'CAT'),
(7, 'Milo', 3, 'CAT'),
(8, 'Oliver', 4, 'CAT'),
(9, 'Simba', 6, 'CAT'),
(10, 'Chloe', 1, 'CAT'),
(11, 'Tweety', 2, 'BIRD'),
(12, 'Sky', 3, 'BIRD'),
(13, 'Sunny', 1, 'BIRD'),
(14, 'Ruby', 4, 'BIRD'),
(15, 'Snow', 2, 'BIRD'),
(16, 'Nibbles', 1, 'HAMSTER'),
(17, 'Fluffy', 2, 'HAMSTER'),
(18, 'Shadow', 3, 'HAMSTER'),
(19, 'Goldie', 1, 'HAMSTER'),
(20, 'Smokey', 2, 'HAMSTER');

-- Create the cat table
CREATE TABLE cat (
  id BIGINT PRIMARY KEY,
  color VARCHAR(255) DEFAULT NULL,
  indoor BOOLEAN DEFAULT NULL,
  FOREIGN KEY (id) REFERENCES pet (id) ON DELETE CASCADE
);

-- Insert data into the cat table
INSERT INTO cat (id, color, indoor) VALUES 
(6, 'Black', TRUE),
(7, 'Gray', FALSE),
(8, 'Orange', TRUE),
(9, 'White', FALSE),
(10, 'Calico', TRUE);

-- Create the dog table
CREATE TABLE dog (
  id BIGINT PRIMARY KEY,
  breed VARCHAR(255) DEFAULT NULL,
  trained BOOLEAN DEFAULT NULL,
  FOREIGN KEY (id) REFERENCES pet (id) ON DELETE CASCADE
);

-- Insert data into the dog table
INSERT INTO dog (id, breed, trained) VALUES 
(1, 'Golden Retriever', TRUE),
(2, 'Labrador Retriever', FALSE),
(3, 'Beagle', TRUE),
(4, 'Poodle', TRUE),
(5, 'Bulldog', FALSE);

-- Create the bird table
CREATE TABLE bird (
  id BIGINT PRIMARY KEY,
  color VARCHAR(255) DEFAULT NULL,
  can_fly BOOLEAN DEFAULT NULL,
  FOREIGN KEY (id) REFERENCES pet (id) ON DELETE CASCADE
);

-- Insert data into the bird table
INSERT INTO bird (id, color, can_fly) VALUES 
(11, 'Green', TRUE),
(12, 'Blue', TRUE),
(13, 'Yellow', FALSE),
(14, 'Red', TRUE),
(15, 'White', FALSE);

-- Create the hamster table
CREATE TABLE hamster (
  id BIGINT PRIMARY KEY,
  color VARCHAR(255) DEFAULT NULL,
  is_cute BOOLEAN DEFAULT NULL,
  FOREIGN KEY (id) REFERENCES pet (id) ON DELETE CASCADE
);

-- Insert data into the hamster table
INSERT INTO hamster (id, color, is_cute) VALUES 
(16, 'Brown', TRUE),
(17, 'White', TRUE),
(18, 'Black', FALSE),
(19, 'Golden', TRUE),
(20, 'Gray', FALSE);