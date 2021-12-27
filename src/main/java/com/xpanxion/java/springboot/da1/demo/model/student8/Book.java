package com.xpanxion.java.springboot.da1.demo.model.student8;

public class Book {

    // DATA

    int id;
    String title;
    String isbn;
    double price;

    // CONSTRUCTOR

    public Book(int id, String title, String isbn, double price) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }

    // ACCESSORS

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

// OVERRIDES


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                '}';
    }
}
