package com.xpanxion.java.springboot.da1.demo.controller.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class BookController8 {

    @Autowired
    private DataAccess8 dataAccess;


    @GetMapping("student8/api/v1/book")
    public Book getThisBook() {
        Book book;
        return book = new Book(5, "a new book", "1234-1234-1234", 7.99);
    }


    @GetMapping("student8/api/v1/books/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        var bookList = dataAccess.getBook(id);
        return bookList.get(0);
    }

    @PostMapping("student8/api/v1/bookstores/{bookstoreID}/books")
    public void addBooktoBookstore(@RequestBody Book book, @PathVariable("bookstoreID") Integer bookstoreID) {
        dataAccess.addBooktoBookstore(book, bookstoreID);
    }

    @Service
    static class DataAccess8 {

        // DATA

        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Autowired
        private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

        private final String SELECT_BOOK_BY_ID = "select * from book where book_id = ?";
        private final String ADD_A_BOOK = "insert into book (title, isbn, price) VALUES (:title, :isbn, :price)";
        private final String ADD_BOOK_TO_BOOKSTORE = "insert into bookstore_book (bookstore_id, book_id, quantity) values (:bookstore_id, :book_id, :quantity)";

        // CONSTRUCTOR

        public DataAccess8() {}

        // METHODS

        public List<Book> getBook(Integer bookId) {
            List<Book> bookList;
            bookList = jdbcTemplate.query(SELECT_BOOK_BY_ID, (row, rowNum) -> {
                int id = Integer.parseInt(row.getString("book_id"));
                String title = row.getString("title");
                String isbn = row.getString("isbn");
                Double price = Double.parseDouble(row.getString("price"));
                return new Book(id, title, isbn, price);
            }, bookId);
            return bookList;
        }

        public void addBooktoBookstore(Book book, Integer bookstoreID) {
            KeyHolder holder = new GeneratedKeyHolder();
            MapSqlParameterSource namedParameters = new MapSqlParameterSource()
                    .addValue("title", book.getTitle())
                    .addValue("isbn", book.getIsbn())
                    .addValue("price", book.getPrice())
                    .addValue("bookstore_id", bookstoreID)
                    .addValue("quantity", 1);
            namedParameterJdbcTemplate.update(ADD_A_BOOK, namedParameters, holder);
            book.setBookId(holder.getKey().intValue());
            namedParameters.addValue("book_id", book.getBookId());
            namedParameterJdbcTemplate.update(ADD_BOOK_TO_BOOKSTORE, namedParameters);
        }

    }

}

