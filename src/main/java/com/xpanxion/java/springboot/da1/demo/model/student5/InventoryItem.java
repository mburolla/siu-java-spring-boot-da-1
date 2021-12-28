package com.xpanxion.java.springboot.da1.demo.model.student5;

import java.math.BigDecimal;

public class InventoryItem {
    private int bookId;
    private String title;
    private String isbn;
    private int quantity;
    private BigDecimal price;
    private BigDecimal total_price;

    public InventoryItem(Book book, int quantity) {
        this.quantity = quantity;
        this.bookId = book.getBook_id();
        this.title = book.getTitle();
        this.isbn = book.getIsbn();
        this.price = book.getPrice();
        this.total_price = price.multiply(BigDecimal.valueOf(quantity));
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }
}
