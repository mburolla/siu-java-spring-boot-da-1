package com.xpanxion.java.springboot.da1.demo.controller.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.Book;
import com.xpanxion.java.springboot.da1.demo.service.student2.DataAccessStudent2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController2 {

    @Autowired
    private DataAccessStudent2 dataAccess;

    @GetMapping("student2/api/v1/book")
    public List<Book> getBook() {
        var bookList = dataAccess.getBook(1);
        return bookList;
    }
}
