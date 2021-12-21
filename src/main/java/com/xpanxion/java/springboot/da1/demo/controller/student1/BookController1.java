package com.xpanxion.java.springboot.da1.demo.controller.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController1 {

    @GetMapping("student1/api/v1/book")
    public Book getBook() {
        return new Book(9, "title 9", "9999-999-999-999", 9.00);
    }
}
