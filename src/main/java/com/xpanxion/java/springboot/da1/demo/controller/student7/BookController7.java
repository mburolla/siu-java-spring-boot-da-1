package com.xpanxion.java.springboot.da1.demo.controller.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController7 {

    @GetMapping("student7/api/v1/book")
    public Book getBook() {
        Book book = new Book("Harry Potter","11111111-111111-111111-11111111",6.00);
        return book;

    }
}

