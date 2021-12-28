package com.xpanxion.java.springboot.da1.demo.controller.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.BookstoreBook;
import com.xpanxion.java.springboot.da1.demo.service.student4.DataServiceStudent4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookStoreController4 {
    @Autowired
    private DataServiceStudent4 dataAccess;

    @GetMapping("student4/api/v1/bookstores/{bookstoreId}/books")
    public List<BookstoreBook> getBookstoreBooks(@PathVariable int bookstoreId) {
        return dataAccess.getBookstoreBooks(bookstoreId);
    }

}