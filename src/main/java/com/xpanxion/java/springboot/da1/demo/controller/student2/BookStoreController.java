package com.xpanxion.java.springboot.da1.demo.controller.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.Book;
import com.xpanxion.java.springboot.da1.demo.service.student2.DataAccessStudent2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookStoreController {

    @Autowired
    private DataAccessStudent2 dataAccess;

    @GetMapping("student2/api/v1/bookstores/1/books")
    public List<Book> getBookstoreBooks() {
        var bookList = dataAccess.getBookstoreBooks(1);
        return bookList;
    }

}
