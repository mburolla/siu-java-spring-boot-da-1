package com.xpanxion.java.springboot.da1.demo.controller.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
public class BookController4 {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String SELECT_BOOK = "select * from book where book_id = ?";
    private final String INSERT_BOOK = "insert into book (title, isbn, price) values (:title, :isbn, :price)";
    private final String LINK_BOOKSTORE = "insert into bookstore_book (bookstore_id, book_id, quantity) values (:bookstore_id, :book_id, :quantity)";

    @GetMapping("student4/api/v1/book")
    public List<Book> getBook() {
        int bookId = 1;
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

    @PostMapping("student4/api/v1/bookstores/{bookstoreId}/books")
    public Book insertBook(@PathVariable int bookstoreId, @RequestBody Book book) {
        final KeyHolder keyId = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new MapSqlParameterSource("title", book.getTitle())
                                                              .addValue("isbn", book.getIsbn())
                                                              .addValue("price", book.getPrice());
        namedParameterJdbcTemplate.update(INSERT_BOOK, namedParameters, keyId);

        SqlParameterSource bookstore_bookValues = new MapSqlParameterSource("bookstore_id", bookstoreId)
                                                                  .addValue("book_id", keyId.getKey())
                                                                  .addValue("quantity", 1);
        namedParameterJdbcTemplate.update(LINK_BOOKSTORE, bookstore_bookValues);
        book.setId(keyId.getKey().intValue());
        return book;
    }
}


