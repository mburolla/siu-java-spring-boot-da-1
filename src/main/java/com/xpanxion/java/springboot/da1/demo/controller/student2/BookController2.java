package com.xpanxion.java.springboot.da1.demo.controller.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController2 {

    @GetMapping("student2/api/v1/book")
    public String getMessage() {
        Book book = new Book(1, "title-1","1111-111-111-1111", 1.00);
        return book.toString();
    }
}
