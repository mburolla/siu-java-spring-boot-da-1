package com.xpanxion.java.springboot.da1.demo.controller.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Book;
import com.xpanxion.java.springboot.da1.demo.model.student9.BookInventoryBook;
import com.xpanxion.java.springboot.da1.demo.service.student9.DataServiceStudent9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookStoreController9 {
    @Autowired
    private DataServiceStudent9 dataAccess;

    @GetMapping("student9/api/v1/bookstores/{bookstoreId}/books")
    public List<BookInventoryBook> getBookStoreInventory(@PathVariable Integer bookstoreId) {
        return dataAccess.getBookStoreInventory(bookstoreId);

    }
}

