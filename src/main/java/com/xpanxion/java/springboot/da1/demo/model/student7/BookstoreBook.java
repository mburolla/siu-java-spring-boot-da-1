package com.xpanxion.java.springboot.da1.demo.model.student7;

public class BookstoreBook {
    private int bookId;
    private String title;
    private String isbn;
    private int quantity;
    private String price;
    private String totalPrice;

    public BookstoreBook(int bookId, String title, String isbn, int quantity, String price, String totalPrice) {
        this.bookId=bookId;
        this.title=title;
        this.isbn=isbn;
        this.quantity=quantity;
        this.price=price;
        this.totalPrice=totalPrice;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
