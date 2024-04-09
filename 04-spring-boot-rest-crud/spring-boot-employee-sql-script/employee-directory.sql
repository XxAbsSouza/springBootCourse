--CREATE DATABASE  IF NOT EXISTS `employee_directory`;
--USE `employee_directory`;
--
----
---- Table structure for table `employee`
----
--
--DROP TABLE IF EXISTS `employee`;
--
--CREATE TABLE `employee` (
--  `id` int NOT NULL AUTO_INCREMENT,
--  `first_name` varchar(45) DEFAULT NULL,
--  `last_name` varchar(45) DEFAULT NULL,
--  `email` varchar(45) DEFAULT NULL,
--  PRIMARY KEY (`id`)
--) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
--
----
---- Data for table `employee`
----
--
--INSERT INTO `employee` VALUES 
--	(1,'Leslie','Andrews','leslie@luv2code.com'),
--	(2,'Emma','Baumgarten','emma@luv2code.com'),
--	(3,'Avani','Gupta','avani@luv2code.com'),
--	(4,'Yuri','Petrov','yuri@luv2code.com'),
--	(5,'Juan','Vega','juan@luv2code.com');


-- Create the database if it doesn't exist
--CREATE DATABASE IF NOT EXISTS employee_directory;

-- Connect to the employee_directory database
--\c employee_directory;

--
-- Table structure for table employee
--

DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id SERIAL PRIMARY KEY,
  first_name varchar(45),
  last_name varchar(45),
  email varchar(45)
);

--
-- Data for table employee
--

INSERT INTO employee (first_name, last_name, email) VALUES 
    ('Leslie', 'Andrews', 'leslie@luv2code.com'),
    ('Emma', 'Baumgarten', 'emma@luv2code.com'),
    ('Avani', 'Gupta', 'avani@luv2code.com'),
    ('Yuri', 'Petrov', 'yuri@luv2code.com'),
    ('Juan', 'Vega', 'juan@luv2code.com');