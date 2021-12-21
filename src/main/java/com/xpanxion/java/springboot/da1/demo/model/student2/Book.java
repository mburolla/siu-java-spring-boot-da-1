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

    public int getId() {
        return book_id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPrice() {
        return "$" + String.format("%.2f", price);
    }
}