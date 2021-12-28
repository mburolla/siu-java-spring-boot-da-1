package com.xpanxion.java.springboot.da1.demo.model.student8;

import java.text.NumberFormat;

public class Book {

    // DATA

    int bookId;
    String title;
    String isbn;
    int quantity;
    double price;
    double totalCost;
    String displayCost;

    // CONSTRUCTOR

    public Book(int bookId, String title, String isbn, double price) {
        this.bookId = bookId;
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }

    public Book(int bookId, String title, String isbn, int quantity, double price, double totalCost) {
        this.bookId = bookId;
        this.title = title;
        this.isbn = isbn;
        this.quantity = quantity;
        this.price = price;
        this.totalCost = totalCost;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        this.displayCost = formatter.format(totalCost);
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

    public int getQuantity() {
        return quantity;
    }

    public int getBookId() {
        return bookId;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getDisplayCost() {
        return displayCost;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    // OVERRIDES

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + bookId +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", totalCost=" + totalCost +
                '}';
    }
}
