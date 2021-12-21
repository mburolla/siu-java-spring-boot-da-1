package com.xpanxion.java.springboot.da1.demo.controller.student5;
import com.xpanxion.java.springboot.da1.demo.model.student5.Book5;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController5 {

    @GetMapping("student5/api/v1/book")
    public Book5 getBook() {
        return new Book5(1, "This is a book", "1111-111-111-1111", 9.99);
    }
}