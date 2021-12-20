package com.xpanxion.java.springboot.da1.demo.model.student2;

public class Book {
    private int book_id;
    private String title;
    private String isbn;
    private double price;

    public Book() {
        this.book_id = 1;
        this.title = "title-1";
        this.isbn = "1111-111-111-1111";
        this.price = 1.00;
    }

    public String getBook() {
        return  "Book ID: " + Integer.toString(book_id)
                + "\nBook title: " + title
                + "\nBook isbn: " + isbn
                + "\nBook price: " + price;
    }
}
