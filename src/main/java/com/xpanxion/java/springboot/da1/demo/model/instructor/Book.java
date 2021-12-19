package com.xpanxion.java.springboot.da1.demo.model.instructor;

public class Book {

    //
    // Data members
    //

    private Integer id;
    private String title;
    private String isbn;
    private float price;

    //
    // Constructors
    //

    public Book() {
    }

    public Book(String title, String isbn, float price) {
        this.price = price;
        this.title = title;
        this.isbn = isbn;
    }

    public Book(Integer id, String title, String isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
    }

    public Book(Integer id, String title, String isbn, float price) {
        this.price = price;
        this.id = id;
        this.title = title;
        this.isbn = isbn;
    }

    //
    // Accessors
    //

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
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
}
