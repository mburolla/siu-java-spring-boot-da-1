package com.xpanxion.java.springboot.da1.demo.controller.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.xpanxion.java.springboot.da1.demo.service.student7.DataService7;

import java.util.List;

@RestController
public class BookController7 {

    @Autowired
    private DataService7 dataService;

    @GetMapping("student7/api/v1/book")
    public List<Book> getBook() {
     return dataService.getBook();
    }

    @PostMapping("Student7/api/v1/bookstores/{bookstoreId}/books")
    public void insertBook(@PathVariable int bookstoreId, @RequestBody Book Book) {
       dataService.insertBook(bookstoreId, Book);
    }
}

