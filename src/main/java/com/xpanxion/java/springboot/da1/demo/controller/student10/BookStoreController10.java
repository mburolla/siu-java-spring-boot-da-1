package com.xpanxion.java.springboot.da1.demo.controller.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.Bookstore;
import com.xpanxion.java.springboot.da1.demo.service.student10.DataService10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookStoreController10 {

    @Autowired
    private DataService10 dataService;

    @GetMapping ("student10/api/v1/bookstores/{bookstoreId}/books")
    public List<Bookstore> getBooks(@PathVariable int bookstoreId){
        return dataService.getBooks(bookstoreId);
    }
}
