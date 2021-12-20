package com.xpanxion.java.springboot.da1.demo.controller.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.Book7;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController3 {

    @GetMapping("student3/api/v1/book")
    public Book7 getBook(){
            Book7 book = new Book7(1,"Of Mice and Men", "1111-1111-1111-1111", 9.99);
            return book;
    }
}
