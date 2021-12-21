package com.xpanxion.java.springboot.da1.demo.model.student4;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


    public class Book {

        @Id
        // @GeneratedValue
        private int id;
        private String title;
        private int isbn;
        private double price;

        public Book(int id, String title, int isbn, double price) {
            this.id = id;
            this.title = title;
            this.isbn = isbn;
            this.price = price;
        }

        public Book() { // Required.
            this.id = 1;
            this.title = "Java";
            this.isbn = 1234;
            this.price = 23.40;
        }

        public int getId() {return id;}

        public void setId(int id) {this.id = id;}

        public String getTitle() {return title;}

        public void setTitle(String title) {this.title = title;}

        public int getIsbn() {return isbn;}

        public void setIsbn(int isbn) {this.isbn = isbn;}

        public double getPrice() {return price;}

        public void setPrice(double price) {this.price = price;}
    }


