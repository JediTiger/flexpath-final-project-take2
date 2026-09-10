-- Create tables for test db
-- SQL lines exported from MySql Workbench

-- Drop tables just in case they still exist in memory
DROP TABLE IF EXISTS `service_records`;
DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `vehicles`;
DROP TABLE IF EXISTS `users`;

-- 1st: Users table
CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
);

-- 2nd: Roles table (Derived from users)
CREATE TABLE `roles` (
  `username` varchar(255) NOT NULL,
  `role` varchar(250) NOT NULL,
  PRIMARY KEY (`username`,`role`),
  CONSTRAINT `roles_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE
);

-- 3rd: Vehicles table (tied to user)
CREATE TABLE `vehicles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `make` varchar(50) NOT NULL,
  `model` varchar(50) NOT NULL,
  `year` int NOT NULL,
  `is_private` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
);

-- 4th: Service Records table (tied to vehicles)
CREATE TABLE `service_records` (
  `id` int NOT NULL AUTO_INCREMENT,
  `vehicle_id` int NOT NULL,
  `service_name` varchar(100) NOT NULL,
  `service_provider` varchar(100) DEFAULT NULL,
  `description` text,
  `cost` decimal(10,2) NOT NULL,
  `mileage` int DEFAULT NULL,
  `service_date` date NOT NULL,
  `is_private` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  CONSTRAINT `service_records_ibfk_1` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`id`) ON DELETE CASCADE
);
