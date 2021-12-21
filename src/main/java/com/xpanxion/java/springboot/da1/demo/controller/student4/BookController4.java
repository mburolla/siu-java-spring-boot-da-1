package com.xpanxion.java.springboot.da1.demo.controller.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@RestController
public class BookController4 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String SELECT_BOOK = "select * from book where book_id = ?";

    @GetMapping("student4/api/v1/book")
    public List<Book> getBook() {
        int bookId = 1;
        List<Book> bookList;
        bookList = jdbcTemplate.query(SELECT_BOOK, (row, rowNum) -> {
            int id = Integer.parseInt(row.getString("book_id"));
            String title = row.getString("title");
            String isbn = row.getString("isbn");
            Double price = Double.parseDouble(row.getString("price"));
            return new Book(id, title, isbn, price);
        }, bookId);
        return bookList;
    }
}



