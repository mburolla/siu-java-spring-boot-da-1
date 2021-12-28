package com.xpanxion.java.springboot.da1.demo.controller.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Book;
import com.xpanxion.java.springboot.da1.demo.service.student4.DataServiceStudent4;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


public class BookController4{

    @Autowired
    private DataServiceStudent4 dataAccess;

    @GetMapping("student4/api/v1/book")
    public Book getBook() {
        return getBook();
    }

    @PostMapping("student4/api/v1/bookstores/{bookstoreId}/books")
    public Book insertBook(@PathVariable Integer bookstoreId, @RequestBody Book book){
        dataAccess.insertBook(bookstoreId,book);
        return book;
    }
}