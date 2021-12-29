package com.xpanxion.java.springboot.da1.demo.controller.student6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Service
public class DataAccess {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String SELECT_BOOK = "select * from book where id = ?";


    public List<Book> getBook(Integer bookId) {
        List<Book> bookList;
        bookList = jdbcTemplate.query(SELECT_BOOK, (row, rowNum) -> {
            var id = Integer.parseInt(row.getString("id"));
            var title = row.getString("title");
            var isbn = Integer.parseInt(row.getString("isbn"));
            var price = Integer.parseInt(row.getString("price"));

            return new Book(id, title, isbn, price);

        }, bookId);
        return bookList;
    }


}
