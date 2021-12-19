package com.xpanxion.java.springboot.da1.demo.controller.instructor;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import com.xpanxion.java.springboot.da1.demo.model.instructor.Book;
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
public class BookController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String SELECT_BOOK = "select * from book where book_id = ?";
    private final String INSERT_BOOK = "insert into book (title, isbn) values (:title, :isbn);";
    private final String INSERT_BOOKSTORE_BOOK = "insert into bookstore_book (bookstore_id, book_id) values (:bookstoreId, :bookId);";

    @Transactional
    @GetMapping("instructor/api/v1/books")
    public List<Book> getBooks() {
        //return getBook(1);

        var newBookId = addBook(1, new Book("Gypsy", "5150-5150-5150-5150-5150", 1.11F));

        var bookList = new ArrayList<Book>();
        bookList.add(new Book(1, "title 1", "111-11-11111"));
        bookList.add(new Book(2, "title 2", "222-222-22222"));
        bookList.add(new Book(3, "title 3", "3333-333-3333"));
        return bookList;
    }

    //
    // Private helpers
    //

    private List<Book> getBook(int bookId) {
        List<Book> bookList;
        bookList = jdbcTemplate.query(SELECT_BOOK, (row, rowNum) -> {
            var id = Integer.parseInt(row.getString("book_id"));
            var title =  row.getString("title");
            var isbn =  row.getString("isbn");
            return new Book(id, title, isbn);
        }, bookId);
        return bookList;
    }

    private int addBook(Integer bookstoreId, Book book) {
        int retval = 0;

        // Insert into book.
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("title", book.getTitle())
                .addValue("isbn", book.getIsbn());
        namedParameterJdbcTemplate.update(INSERT_BOOK, parameters, holder);
        retval = Objects.requireNonNull(holder.getKey()).intValue();

        // Insert into bookstore_book.
        parameters = new MapSqlParameterSource()
                .addValue("bookstoreId", bookstoreId)
                .addValue("bookId", retval);
        namedParameterJdbcTemplate.update(INSERT_BOOKSTORE_BOOK, parameters);

        return retval;
    }
}
