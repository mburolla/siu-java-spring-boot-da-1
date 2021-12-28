package com.xpanxion.java.springboot.da1.demo.model.student9;

public class BookInventoryBook {
    private int book_id;
    private String title;
    private String isbn;
    private int quantity;
    private double price;
    private double totalPrice;

    public BookInventoryBook(){}

    public BookInventoryBook(int book_id,String title, String isbn,int quantity, double price, double totalPrice){
        this.book_id = book_id;
        this.title = title;
        this.isbn = isbn;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookInventoryBook{");
        sb.append("book_id=").append(book_id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", isbn='").append(isbn).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append('}');
        return sb.toString();
    }
}
