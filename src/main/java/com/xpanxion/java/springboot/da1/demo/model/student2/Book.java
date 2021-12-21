package com.xpanxion.java.springboot.da1.demo.model.student2;

public class Book {
    private int book_id;
    private String title;
    private String isbn;
    private double price;

    public Book(int book_id, String title, String isbn, double price) {
        this.book_id = book_id;
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }

    public String toString() {
        return  "Book ID: " + Integer.toString(book_id)
                + "\nBook title: " + title
                + "\nBook isbn: " + isbn
                + "\nBook price: " + price;
    }
}
