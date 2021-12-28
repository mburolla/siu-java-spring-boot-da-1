package com.xpanxion.java.springboot.da1.demo.controller.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.BookstoreBook;
import com.xpanxion.java.springboot.da1.demo.service.student7.DataService7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookstoreController7 {

    @Autowired
    DataService7 dataService;


    @GetMapping("student7/api/v1/bookstores/{bookstoreId}/books")
    public List<BookstoreBook> getPrice(@PathVariable int bookstoreId) {
        return dataService.getPrice(bookstoreId);
    }
}
