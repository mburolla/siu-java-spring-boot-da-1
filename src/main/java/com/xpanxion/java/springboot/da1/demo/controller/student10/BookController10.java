package com.xpanxion.java.springboot.da1.demo.controller.student10;

import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import com.xpanxion.java.springboot.da1.demo.model.student10.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BookController10 {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String SELECT_BOOK = "select * from book where book_id = ?";

    @GetMapping("student10/api/v1/book")
    public List<Book> getBook(){
        List<Book> bookList;
        bookList = jdbcTemplate.query(SELECT_BOOK, (row, rowNum) -> {
            var id = Integer.parseInt(row.getString("book_id"));
            var title =  row.getString("title");
            var isbn = row.getString("isbn");
            var price = Double.parseDouble(row.getString("price"));
            return new Book(id, title, isbn, price);
        }, 1);
        return bookList;
    }
}
