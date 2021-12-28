package com.xpanxion.java.springboot.da1.demo.model.student5;


import com.xpanxion.java.springboot.da1.demo.service.student5.DataAccessStudent5;

public class InventoryItem {
    private int bookId;
    private String title;
    private String isbn;
    private int quantity;
    private double price;
    private double total_price;

    public InventoryItem(Book book, int quantity) {
        this.quantity = quantity;
        this.bookId = book.getBook_id();
        this.title = book.getTitle();
        this.isbn = book.getIsbn();
        this.price = book.getPrice();
        this.total_price = this.price * this.quantity;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
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

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
}
