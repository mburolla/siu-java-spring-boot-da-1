package com.xpanxion.java.springboot.da1.demo.model.student4;

public class BookstoreBook {
    private int book_id;
    private String title;
    private String isbn;
    private int quantity;
    private double price;
    private double total_price;

    public BookstoreBook(int book_id, String title, String isbn, int quantity, double price, double total_price) {
        this.book_id = book_id;
        this.title = title;
        this.isbn = isbn;
        this.quantity = quantity;
        this.price = price;
        this.total_price = total_price;
    }
    public int getBook_id() {return book_id;}
    public void setBook_id(int book_id) {this.book_id = book_id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getIsbn() {return isbn;}
    public void setIsbn(String isbn) {this.isbn = isbn;}

    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public double getTotal_price() {return total_price;}
    public void setTotal_price(double total_price) {this.total_price = total_price;}

}
