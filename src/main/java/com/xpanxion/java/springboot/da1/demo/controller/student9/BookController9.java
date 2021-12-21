package com.xpanxion.java.springboot.da1.demo.controller.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController9 {
    @Autowired
    private DataAccess dataAccess;

    @GetMapping("student9/api/v1/book")
    public Book getBook() {
        var temp = dataAccess.getBook(1);
        return temp;
    }

}

@Service
 class DataAccess{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String SELECT_BOOK = "SELECT * FROM book WHERE book_id = ?";

    public DataAccess() { }

    public Book getBook(int bookId) {

        var book = jdbcTemplate.query(SELECT_BOOK, (row, rowNum) -> {
            var id = Integer.parseInt(row.getString("book_id"));
            var title =  row.getString("title");
            var isbn = row.getString("isbn");
            var price = Double.parseDouble(row.getString("price"));
            return new Book(id, title,isbn,price);
        }, bookId);

        if(book.get(0) == null){
            System.out.println("No Book found");
            return null;
        } else {
            return book.get(0);
        }
    }

}

