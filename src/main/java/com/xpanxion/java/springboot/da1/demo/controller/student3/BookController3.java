package com.xpanxion.java.springboot.da1.demo.controller.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController3 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate template;

    private final String SELECT_BOOK = "select * from book where book_id = ?";
    private final String ADD_BOOK = "insert into book (title, isbn, price) values (:title, :isbn, :price)";
    private final String LINK_BOOK_BOOKSTORE = "insert into bookstore_book (bookstore_id, book_id, quantity) values (:bookstore_id, :book_id, :quantity)";

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

    @PostMapping("student3/api/v1/bookstores/{bookstoreId}/books")
    public Book addBook (@RequestBody Book book, @PathVariable Integer bookstoreId, @RequestParam int quantity){
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("title", book.getTitle())
                .addValue("isbn", book.getIsbn())
                .addValue("price", book.getPrice());
        template.update(ADD_BOOK, parameters, keyHolder);

        var bookId = keyHolder.getKey().intValue();

        MapSqlParameterSource bookstoreParameters = new MapSqlParameterSource()
                .addValue("bookstore_id", bookstoreId)
                .addValue("book_id", bookId)
                .addValue("quantity", quantity);
        template.update(LINK_BOOK_BOOKSTORE, bookstoreParameters);
        book.setId(bookId);
        return book;
    }
}
