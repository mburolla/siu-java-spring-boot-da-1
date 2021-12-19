/*
 * File: U_0.0.1.sql
 * Auth: Martin Burolla
 * Date: 12/18/20201
 */

CREATE TABLE `book` (
  `book_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `isbn` varchar(45) DEFAULT NULL,
  `price` decimal(13,2) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `manager` (
  `manager_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `bookstore` (
  `bookstore_id` int NOT NULL AUTO_INCREMENT,
  `manager_id` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`bookstore_id`),
  KEY `fk_manager_id_idx` (`manager_id`),
  CONSTRAINT `fk_manager_id` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `bookstore_book` (
  `bookstore_book_id` int NOT NULL AUTO_INCREMENT,
  `bookstore_id` int NOT NULL,
  `book_id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`bookstore_book_id`),
  KEY `fk_bookstore_id_idx` (`bookstore_id`),
  CONSTRAINT `fk_book_id` FOREIGN KEY (`bookstore_id`) REFERENCES `bookstore` (`bookstore_id`),
  CONSTRAINT `fk_bookstore_id` FOREIGN KEY (`bookstore_id`) REFERENCES `book` (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


/**
 * Data
 */

Insert into manager (full_name) values ('Alice Smith');
Insert into manager (full_name) values ('Bob Jones');
Insert into manager (full_name) values ('Charlie Max');

Insert into bookstore (name, manager_id) values ('Barnes and Noble', 1);
Insert into bookstore (name, manager_id) values ('Books and More', 2);
Insert into bookstore (name, manager_id) values ('Coffee and Books', 3);

Insert into book (title, isbn, price) values ('title 1', '1111-111-111-1111', 1.00);
Insert into book (title, isbn, price) values ('title 2', '2222-222-222-2222', 2.00);
Insert into book (title, isbn, price) values ('title 3', '3333-333-333-3333', 3.00);
Insert into book (title, isbn, price) values ('title 4', '4444-444-444-4444', 4.00);
Insert into book (title, isbn, price) values ('title 5', '5555-555-555-5555', 5.00);
Insert into book (title, isbn, price) values ('title 6', '6666-666-666-6666', 6.00);
Insert into book (title, isbn, price) values ('title 7', '7777-777-777-7777', 7.00);
Insert into book (title, isbn, price) values ('title 8', '8888-888-888-8888', 8.00);
Insert into book (title, isbn, price) values ('title 9', '9999-999-999-999', 9.00);
Insert into book (title, isbn, price) values ('title 10', '10101010-101010-101010-10101010', 10.00);

insert into bookstore_book (bookstore_id, book_id, quantity) values (1, 1, 1);
insert into bookstore_book (bookstore_id, book_id, quantity) values (1, 2, 2);
insert into bookstore_book (bookstore_id, book_id, quantity) values (1, 3, 3);
insert into bookstore_book (bookstore_id, book_id, quantity) values (1, 4, 4);

insert into bookstore_book (bookstore_id, book_id, quantity) values (2, 5, 5);
insert into bookstore_book (bookstore_id, book_id, quantity) values (2, 6, 6);
insert into bookstore_book (bookstore_id, book_id, quantity) values (2, 7, 7);

insert into bookstore_book (bookstore_id, book_id, quantity) values (3, 8, 8);
insert into bookstore_book (bookstore_id, book_id, quantity) values (3, 9, 9);
insert into bookstore_book (bookstore_id, book_id, quantity) values (3, 10, 10);
