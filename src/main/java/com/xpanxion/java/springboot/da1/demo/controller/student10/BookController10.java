package com.xpanxion.java.springboot.da1.demo.controller.student10;

import com.xpanxion.java.springboot.da1.demo.service.student10.DataService10;
import org.springframework.beans.factory.annotation.Autowired;
import com.xpanxion.java.springboot.da1.demo.model.student10.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController10 {

    @Autowired
    private DataService10 dataService;

    @GetMapping("student10/api/v1/book")
    public List<Book> getBook(){
        return dataService.getBook();
    }

    @PostMapping("student10/api/v1/bookstores/{bookstoreId}/books")
    public Book addBook(@RequestBody Book book, @RequestParam int quantity, @PathVariable int bookstoreId){
        return dataService.addBook(book, quantity, bookstoreId);
    }
}
