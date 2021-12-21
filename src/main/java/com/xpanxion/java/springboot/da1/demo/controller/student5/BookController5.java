package com.xpanxion.java.springboot.da1.demo.controller.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController5 {

    @Autowired
    private DataAccess dataAccess;

    @GetMapping("student5/api/v1/book")
    public Book getBook() {
        return new Book(1, "This is a book", "1111-111-111-1111", 9.99);
    }

    @GetMapping("student5/api/v1/book/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        var bookList = dataAccess.getBook(id);
        return bookList.get(0);
    }
}

@Service
class DataAccess {

    //
    // Data Members
    //

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String SELECT_BOOK = "select * from book where book_id = ?";

    //
    // Constructors
    //

    public DataAccess() {
    }

    //
    // Methods
    //


    public List<Book> getBook(Integer bookId) {
        List<Book> bookList;
        bookList = jdbcTemplate.query(SELECT_BOOK, (row, rowNum) -> {
            var id = Integer.parseInt(row.getString("book_id"));
            var title =  row.getString("title");
            var isbn =  row.getString("isbn");
            var price = Double.parseDouble(row.getString("price"));
            return new Book(id, title, isbn, price);
        }, bookId);
        return bookList;
    }
}
