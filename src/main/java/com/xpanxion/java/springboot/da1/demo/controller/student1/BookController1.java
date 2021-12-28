package com.xpanxion.java.springboot.da1.demo.controller.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Book;
import com.xpanxion.java.springboot.da1.demo.service.student1.DataService1;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController1 {

    @Autowired
    private DataService1 dataService1;

    @GetMapping("student1/api/v1/book")
    public Book getBook() {
        return new Book(9, "title 9", "9999-999-999-999", 9.00);
    }

    @GetMapping("student1/api/v1/book/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        var bookList = dataService1.getBook(id);
        return bookList.get(0);
    }

    @PostMapping("student1/api/v1/bookstores/{bookstoreId}/books")
    public void insertBook(@PathVariable("bookstoreId") Integer bookstoreId, @RequestBody Book newBook) {
        int bookId = dataService1.insertBook(newBook);
        dataService1.addToBookstore(newBook, bookstoreId, bookId);
    }

}
