package com.xpanxion.java.springboot.da1.demo.model.student10;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Book {

    private int book_id;
    private String title;
    private String isbn;
    private double price;

    public Book() {
    }

    public Book(int book_id, String title, String isbn, double price) {
        this.book_id = book_id;
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }

    public int getId() {
        return book_id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int book_id) {
        this.book_id = book_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
