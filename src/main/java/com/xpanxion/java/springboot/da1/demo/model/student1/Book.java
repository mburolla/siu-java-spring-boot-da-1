package com.xpanxion.java.springboot.da1.demo.model.student1;

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

    public int getBook_id() { return book_id; }

    public void setBook_id(int book_id) { this.book_id = book_id; }

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
        return getClass().getSimpleName();
    }
}
