package com.xpanxion.java.springboot.da1.demo.controller.student6;

public class Book {

    //MEM VARS
    private int id;
    private String title;
    private int isbn;
    private int price;

    //CONSTRUCTORS


    public Book(int id, String title, int isbn, int price) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }

    //GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int bookId) {
        this.id = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //TOSTRING

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + id +
                ", title='" + title + '\'' +
                ", isbn=" + isbn +
                ", price=" + price +
                '}';
    }
}
