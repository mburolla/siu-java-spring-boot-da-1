package com.xpanxion.java.springboot.da1.demo.controller.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class BookController8 {

    @Autowired
    private DataAccess dataAccess;


    @GetMapping("student8/api/v1/book")
    public Book getThisBook() {
        Book book;
        return book = new Book(5, "a new book", "1234-1234-1234", 7.99);
    }


    @GetMapping("student8/api/v1/books/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        var bookList = dataAccess.getBook(id);
        return bookList.get(0);
    }

    @Service
    static class DataAccess {

        // DATA

        @Autowired
        private JdbcTemplate jdbcTemplate;
        private final String SELECT_BOOK = "select * from book where book_id = ?";

        // CONSTRUCTOR

        public DataAccess() {

        }

        // METHODS

        public List<Book> getBook(Integer bookId) {
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

}

