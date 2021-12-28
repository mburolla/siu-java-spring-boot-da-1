package com.xpanxion.java.springboot.da1.demo.controller.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Book;
import com.xpanxion.java.springboot.da1.demo.service.student8.DataService8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookStoreController8 {

    @Autowired
    private DataService8 dataService8;

    @GetMapping("student8/api/v1/bookstores/{bookstoreId}/books")
    public List<Book> getBooksInBookstore(@PathVariable("bookstoreId") Integer id) {
        var bookList = dataService8.getBooksInBookstore(id);
        return bookList;
    }

}
