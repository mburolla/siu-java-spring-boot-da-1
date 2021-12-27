package com.xpanxion.java.springboot.da1.demo.controller.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController7 {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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

    @PostMapping("Student7/api/v1/bookstores/{bookstoreId}/books")
    public void insertBook(@PathVariable int bookstoreId, @RequestBody Book Book) {
        String INSERT_BOOK = "INSERT INTO book(title, isbn, price) Values (:title, :isbn, :price)";
        String LINK_BOOKSTORE = "INSERT INTO bookstore_book(bookstore_id, book_id,quantity) VALUES (:bookstoreId,:bookId,:quantity)";
        final KeyHolder keyId = new GeneratedKeyHolder();

//        Creates book and grabs book_id
        SqlParameterSource namedParameters = new MapSqlParameterSource("title", Book.getTitle())
                .addValue("isbn", Book.getIsbn())
                .addValue("price", Book.getPrice());
        namedParameterJdbcTemplate.update(INSERT_BOOK, namedParameters,keyId);

        SqlParameterSource bookstoreParameters = new MapSqlParameterSource("bookstoreId", bookstoreId)
                .addValue("bookId", keyId.getKey().intValue())
                .addValue("quantity", 1);
        namedParameterJdbcTemplate.update(LINK_BOOKSTORE, bookstoreParameters);
    }
}

