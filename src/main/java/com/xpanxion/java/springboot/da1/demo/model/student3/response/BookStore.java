package com.xpanxion.java.springboot.da1.demo.model.student3.response;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class BookStore {

    private int bookId;
    private int quantity;
    private String title;
    private String isbn;
    private String displayTotalPrice;
    private double price;
    private BigDecimal totalPrice;

    public BookStore(int bookId, String title, String isbn, int quantity, double price, BigDecimal totalPrice){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        this.bookId = bookId;
        this.title = title;
        this.isbn = isbn;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.displayTotalPrice = formatter.format(totalPrice);


    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice =  totalPrice;
    }

    public String getDisplayTotalPrice() {
        return displayTotalPrice;
    }

    public void setDisplayTotalPrice(String displayTotalPrice) {
        this.displayTotalPrice = displayTotalPrice;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "bookId=" + bookId +
                ", quantity=" + quantity +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", moneyString='" + displayTotalPrice + '\'' +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

