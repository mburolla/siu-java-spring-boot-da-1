package com.xpanxion.java.springboot.da1.demo.controller.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.BookstoreBook;
import com.xpanxion.java.springboot.da1.demo.service.student1.DataService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookstoreController1 {

    @Autowired
    DataService1 dataService1;

    @GetMapping("student1/api/v1/bookstores/{bookstoreId}/books")
    public List<BookstoreBook> getBookstoreBooks(@PathVariable("bookstoreId") int bookstoreId) {

        var bookstoreBooks = dataService1.getBookstoreBooks(bookstoreId);
        return bookstoreBooks;

    }

}
