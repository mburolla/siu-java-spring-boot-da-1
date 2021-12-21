package com.xpanxion.java.springboot.da1.demo.model.student5;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

public class Book {
    @Id
    private int book_id;
    private String title;
    private String isbn;
    private double price;

    public Book() {
        this.book_id = -1;
        this.title = "";
        this.isbn = "";
        this.price = -1;
    }

    public Book(int book_id, String title, String isbn, double price) {
        this.book_id = book_id;
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                '}';
    }
}
