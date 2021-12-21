package com.xpanxion.java.springboot.da1.demo.controller.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController8 {

    @GetMapping("student8/api/v1/book")
    public Book getBook() {
        Book book;
        return book = new Book("a new book", "1234-1234-1234", 7.99);
    }

}

