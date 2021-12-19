/*
 * Schema
 */

drop table bookstore_book;
drop table book;
drop table bookstore;

CREATE TABLE `book` (
  `book_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `isbn` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `bookstore` (
  `bookstore_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`bookstore_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `bookstore_book` (
  `bookstore_book_id` int NOT NULL AUTO_INCREMENT,
  `bookstore_id` int NOT NULL,
  `book_id` int NOT NULL,
  PRIMARY KEY (`bookstore_book_id`),
  KEY `fk_bookstore_id_idx` (`bookstore_id`),
  CONSTRAINT `fk_book_id` FOREIGN KEY (`bookstore_id`) REFERENCES `bookstore` (`bookstore_id`),
  CONSTRAINT `fk_bookstore_id` FOREIGN KEY (`bookstore_id`) REFERENCES `book` (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/**
 * Data
 */

Insert into bookstore(name) values ('Barnes and Noble');
Insert into `instructor`.`book` (`title`,`isbn`) values ('title 1', '1111-111-111-1111');
Insert into `instructor`.`book` (`title`,`isbn`) values ('title 2', '2222-222-222-2222');
Insert into `instructor`.`book` (`title`,`isbn`) values ('title 3', '3333-333-333-3333');
Insert into `instructor`.`book` (`title`,`isbn`) values ('title 4', '4444-444-444-4444');
insert into bookstore_book (bookstore_id, book_id) values (1,1);
insert into bookstore_book (bookstore_id, book_id) values (1,2);
insert into bookstore_book (bookstore_id, book_id) values (1,3);
insert into bookstore_book (bookstore_id, book_id) values (1,4);
