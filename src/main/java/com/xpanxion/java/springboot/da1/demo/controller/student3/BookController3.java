package com.xpanxion.java.springboot.da1.demo.controller.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.Book3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController3 {

    @GetMapping("student3/api/v1/book")
    public Book3 getBook(){
            Book3 book = new Book3(1,"Of Mice and Men", "1111-1111-1111-1111", 9.99);
            return book;
    }
}
