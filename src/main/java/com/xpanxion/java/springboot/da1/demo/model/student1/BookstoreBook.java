package com.xpanxion.java.springboot.da1.demo.model.student1;

public class BookstoreBook {

    private int bookId;
    private String title;
    private String isbn;
    private int quantity;
    private double price;
    private double totalPrice;

    public BookstoreBook(int bookId, String title, String isbn, int quantity, double price, double totalPrice) {
        this.bookId = bookId;
        this.title = title;
        this.isbn = isbn;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public int getBook_id() {
        return bookId;
    }

    public void setBook_id(int bookId) {
        this.bookId = bookId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
