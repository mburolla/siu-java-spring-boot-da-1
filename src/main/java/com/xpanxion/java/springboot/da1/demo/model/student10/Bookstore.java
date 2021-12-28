package com.xpanxion.java.springboot.da1.demo.model.student10;

public class Bookstore {

    private int bookId;
    private String title;
    private String isbn;
    private int quantity;
    private Double price;
    private Double totalPrice;

    public Bookstore(int bookId, String title, String isbn, int quantity, Double price, Double totalPrice) {
        this.bookId = bookId;
        this.title = title;
        this.isbn = isbn;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    //Getters
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    //Setters
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
