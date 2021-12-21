package com.xpanxion.java.springboot.da1.demo.model.student4;

import javax.persistence.Id;


public class Book {

        @Id
        // @GeneratedValue
        private int id;
        private String title;
        private String isbn;
        private double price;

        public Book(int id, String title, String isbn, double price) {
            this.id = id;
            this.title = title;
            this.isbn = isbn;
            this.price = price;
        }

        public Book() { // Required.
            this.id = 1;
            this.title = "Java";
            this.isbn = "1234-2334-3444-4324";
            this.price = 23.40;
        }

        public int getId() {return id;}

        public void setId(int id) {this.id = id;}

        public String getTitle() {return title;}

        public void setTitle(String title) {this.title = title;}

        public String getIsbn() {return isbn;}

        public void setIsbn(String isbn) {this.isbn = isbn;}

        public double getPrice() {return price;}

        public void setPrice(double price) {this.price = price;}

    }


