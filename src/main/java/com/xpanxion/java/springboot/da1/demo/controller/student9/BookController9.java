package com.xpanxion.java.springboot.da1.demo.controller.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController9 {
    @GetMapping("student9/api/v1/book")
    public Book getBook() {
        return new Book(1,"title",1232342342,19.99);
    }

}