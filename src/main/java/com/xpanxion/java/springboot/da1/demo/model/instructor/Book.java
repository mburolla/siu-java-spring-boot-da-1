package com.xpanxion.java.springboot.da1.demo.model.instructor;

public class Book {

    private Integer id;
    private String title;
    private String isbn;

    public Book() {
    }

    public Book(Integer id, String title, String isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
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
