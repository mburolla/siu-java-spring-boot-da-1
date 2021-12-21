package com.xpanxion.java.springboot.da1.demo.model.student8;

public class Book {

    String name;
    String isbn;
    double price;

    public Book(String name, String isbn, double price) {
        this.name = name;
        this.isbn = isbn;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                '}';
    }
}
