package com.xpanxion.java.springboot.da1.demo.controller.student10;


import com.xpanxion.java.springboot.da1.demo.model.student10.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController10 {

    @GetMapping("student10/api/v1/book")
    public Book getBook() {
        return new Book(1, "A Brief History of Time", 20.00);
    }

}
