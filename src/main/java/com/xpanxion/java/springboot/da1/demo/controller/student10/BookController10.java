package com.xpanxion.java.springboot.da1.demo.controller.student10;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import com.xpanxion.java.springboot.da1.demo.model.student10.Book;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController10 {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String SELECT_BOOK = "select * from book where book_id = ?";
    private final String INSERT_BOOK = "insert into book (title, isbn, price) values (:title, :isbn, :price)";
    private final String INSERT_BOOK_BOOKSTORE = "insert into bookstore_book (bookstore_id, book_id, quantity) values (:bookstore_id, :book_id, :quantity)";

    @GetMapping("student10/api/v1/book")
    public List<Book> getBook(){
        List<Book> bookList;
        bookList = jdbcTemplate.query(SELECT_BOOK, (row, rowNum) -> {
            var id = Integer.parseInt(row.getString("book_id"));
            var title =  row.getString("title");
            var isbn = row.getString("isbn");
            var price = Double.parseDouble(row.getString("price"));
            return new Book(id, title, isbn, price);
        }, 1);
        return bookList;
    }

    @PostMapping("student10/api/v1/bookstores/{bookstoreId}/books")
    public Book addBook(@RequestBody Book book, @RequestParam int quantity, @PathVariable int bookstoreId){
        final KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new MapSqlParameterSource("title", book.getTitle())
                                                .addValue("isbn", book.getIsbn())
                                                .addValue("price", book.getPrice());
        namedParameterJdbcTemplate.update(INSERT_BOOK, namedParameters, holder);
        int bookId = holder.getKey().intValue();
        addBookBookStore(bookId, quantity, bookstoreId);
        book.setId(bookId);
        return book;
    }

    private void addBookBookStore(int bookId, int quantity, int bookstoreId){
        SqlParameterSource namedParameters = new MapSqlParameterSource("book_id", bookId)
                .addValue("bookstore_id", bookstoreId)
                .addValue("quantity", quantity);
        namedParameterJdbcTemplate.update(INSERT_BOOK_BOOKSTORE, namedParameters);
    }
}
