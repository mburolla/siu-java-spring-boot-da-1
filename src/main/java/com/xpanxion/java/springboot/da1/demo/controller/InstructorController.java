package com.xpanxion.java.springboot.da1.demo.controller;

import java.util.List;
import java.util.ArrayList;

import com.xpanxion.java.springboot.da1.demo.model.Book;
import com.xpanxion.java.springboot.da1.demo.model.Product;
import com.xpanxion.java.springboot.da1.demo.service.InstructorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructorController {

    @Autowired
    private InstructorDataService instructorDataService;

    //
    // Message
    //

    @GetMapping("instructor/api/v1/message")
    public String getMessage() {
        return "My name is Marty.";
    }

    //
    // Product
    //

    @GetMapping("instructor/api/v1/products")
    public List<Product> getProducts() {
        var productList = instructorDataService.getProducts();
        return productList;
    }

    //
    // Book
    //

    @GetMapping("instructor/api/v1/books")
    public List<Book> getBooks() {
        var bookList = new ArrayList<Book>();
        bookList.add(new Book("title 1", "111-11-11111"));
        bookList.add(new Book("title 2", "222-222-22222"));
        bookList.add(new Book("title 3", "3333-333-3333"));
        return bookList;
    }
}
