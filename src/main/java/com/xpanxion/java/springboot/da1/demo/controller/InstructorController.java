package com.xpanxion.java.springboot.da1.demo.controller;

import java.util.List;
import java.util.ArrayList;

import com.xpanxion.java.springboot.da1.demo.model.instructor.Book;
import com.xpanxion.java.springboot.da1.demo.model.instructor.Product;
import com.xpanxion.java.springboot.da1.demo.service.InstructorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class InstructorController {

    @Autowired
    private InstructorDataService instructorDataService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String SELECT_BOOK = "select * from book where book_id = ?";
    private final String INSERT_BOOK = "insert into book (title, isbn) values (:title, :isbn);";

    //
    // Message
    //

    @GetMapping("instructor/api/v1/message")
    public String getMessage() {
        return "My name is Marty.";
    }

    //
    // Product
    //

    @GetMapping("instructor/api/v1/products")
    public List<Product> getProducts() {
        return instructorDataService.getProducts();
    }

    //
    // Book
    //

    @Transactional
    @GetMapping("instructor/api/v1/books")
    public List<Book> getBooks() {

        var bookList = new ArrayList<Book>();
        bookList.add(new Book(1, "title 1", "111-11-11111"));
        bookList.add(new Book(2, "title 2", "222-222-22222"));
        bookList.add(new Book(3, "title 3", "3333-333-3333"));
        return bookList;

        //jdbcTemplate.update(INSERT_BOOK, "title5", "5555-555-555-55555" );

        // Get the ID of the newly inserted row.
//        KeyHolder holder = new GeneratedKeyHolder();
//        SqlParameterSource parameters = new MapSqlParameterSource()
//                .addValue("title", "title55")
//                .addValue("isbn", "111-11-111-11111");
//        namedParameterJdbcTemplate.update(INSERT_BOOK, parameters, holder);
//        int bookId = holder.getKey().intValue();


//        KeyHolder holder = new GeneratedKeyHolder();
//        SqlParameterSource parameters = new MapSqlParameterSource()
//                .addValue("name", user.getName())
//                .addValue("address", user.getAddress())
//                .addValue("email", user.getEmail());
//        namedParameterJdbcTemplate.update(INSERT_SQL, parameters, holder);
//        user.setId(holder.getKey().intValue());
//        return user;


//        int bookId = 2;
//        List<Book> bookList;
//        bookList = jdbcTemplate.query(SELECT_BOOK, (row, rowNum) -> {
//            var id = Integer.parseInt(row.getString("book_id"));
//            var title =  row.getString("title");
//            var isbn =  row.getString("isbn");
//            return new Book(id, title, isbn);
//        }, bookId);
//        return bookList;

    }
}
