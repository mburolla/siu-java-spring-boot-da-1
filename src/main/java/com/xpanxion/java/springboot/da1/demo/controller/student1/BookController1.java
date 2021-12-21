package com.xpanxion.java.springboot.da1.demo.controller.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
public class BookController1 {

    @Autowired
    private DataAccess dataAccess;

    @GetMapping("student1/api/v1/book")
    public Book getBook() {
        return new Book(9, "title 9", "9999-999-999-999", 9.00);
    }

    @GetMapping("student1/api/v1/book/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        var bookList = dataAccess.getBook(id);
        return bookList.get(0);
    }

    @Service
    public static class DataAccess {
        @Autowired
        private JdbcTemplate jdbcTemplate;
        private final String SELECT_BOOK = "select * from book where book_id = ?";

        public List<Book> getBook(Integer bookId) {
            List<Book> bookList;
            bookList = jdbcTemplate.query(SELECT_BOOK, (row, rowNum) -> {
                var id = Integer.parseInt(row.getString("book_id"));
                var title =  row.getString("title");
                var isbn = row.getString("isbn");
                var price = Double.parseDouble(row.getString("price"));

                return new Book(id, title, isbn, price);
            }, bookId);
            return bookList;
        }

    }

}
