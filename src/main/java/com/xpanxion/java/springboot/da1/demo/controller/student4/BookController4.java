package com.xpanxion.java.springboot.da1.demo.controller.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
    public class BookController4 {

    @GetMapping("student4/api/v1/book")
        public Book getBook() {
            Book book = new Book(1,"Java",1234,34.56);
            return book;

        }
    }

