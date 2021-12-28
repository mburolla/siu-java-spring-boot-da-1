package com.xpanxion.java.springboot.da1.demo.controller.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Book;
import com.xpanxion.java.springboot.da1.demo.service.student8.DataService8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController8 {

    @Autowired
    private DataService8 dataService8;

    @GetMapping("student8/api/v1/book")
    public Book getThisBook() {
        Book book;
        return book = new Book(5, "a new book", "1234-1234-1234", 7.99);
    }

    @GetMapping("student8/api/v1/books/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        var bookList = dataService8.getBook(id);
        return bookList.get(0);
    }

    @PostMapping("student8/api/v1/bookstores/{bookstoreID}/books")
    public void addBookToBookstore(@RequestBody Book book, @PathVariable("bookstoreID") Integer bookstoreID) {
        dataService8.addBookToBookstore(book, bookstoreID);
    }

}

