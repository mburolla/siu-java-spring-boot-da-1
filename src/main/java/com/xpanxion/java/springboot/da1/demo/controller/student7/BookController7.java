package com.xpanxion.java.springboot.da1.demo.controller.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController7 {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String SELECT_BOOK = "select * from book where book_id = ?";

    @GetMapping("student7/api/v1/book")
    public List<Book> getBook() {
        int numOfBook = 1;
        List<Book> bookList;
        bookList = jdbcTemplate.query(SELECT_BOOK, (rs, rowNum) -> {
            var bookId = Integer.parseInt(rs.getString("book_Id"));
            var title = rs.getString("title");
            var isbn = rs.getString("isbn");
            var price = rs.getDouble("price");
            return new Book(bookId, title, isbn, price);
        },numOfBook);
        return bookList;
    }
}

