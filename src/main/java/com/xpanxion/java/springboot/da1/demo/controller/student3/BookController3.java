package com.xpanxion.java.springboot.da1.demo.controller.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController3 {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String SELECT_BOOK = "select * from book where book_id = ?";


    @GetMapping("student3/api/v1/book")
    public List<Book> getBook() {
        int bookId = 1;
        List<Book> bookList;
        bookList = jdbcTemplate.query(SELECT_BOOK, (row, rowNum) ->{
            var id = Integer.parseInt(row.getString("book_id"));
            var title = row.getString("title");
            var isbn = row.getString("isbn");
            var price = Double.parseDouble(row.getString("price"));
            return new Book(id, title, isbn, price);
        }, bookId);
        return bookList;
    }

//    public Book3 getBook(){
//            Book3 book = new Book3(1,"Of Mice and Men", "1111-1111-1111-1111", 9.99);
//            return book;
//    }
}
