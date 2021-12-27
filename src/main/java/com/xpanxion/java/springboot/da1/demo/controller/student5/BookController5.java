package com.xpanxion.java.springboot.da1.demo.controller.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController5 {

    @Autowired
    private BookDataAccess dataAccess;

    @GetMapping("student5/api/v1/book")
    public Book getBook() {
        return new Book(1, "This is a book", "1111-111-111-1111", 9.99);
    }

    @GetMapping("student5/api/v1/book/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        var bookList = dataAccess.getBook(id);
        return bookList.get(0);
    }

    @PostMapping("student5/api/v1/bookstores/{bookstoreId}/books")
    public void insertBook(@PathVariable("bookstoreId") Integer bookstoreId, @RequestBody Book book) {
        var bookId = dataAccess.insertBook(book);
        dataAccess.insertBookIntoInventory(bookstoreId,bookId,1);
    }
}

@Service
class BookDataAccess {

    //
    // Data Members
    //

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String SELECT_BOOK = "SELECT * FROM book WHERE book_id = ?";
    private final String INSERT_BOOK = "INSERT INTO book (title, isbn, price) VALUES (:title, :isbn, :price)";
    private final String INSERT_BOOK_INTO_INVENTORY = "INSERT INTO bookstore_book (bookstore_id, book_id, quantity) VALUES (:bookstore_id, :book_id, :quantity)";

    //
    // Constructors
    //

    public BookDataAccess() {
    }

    //
    // Methods
    //

    public int insertBook(Book book) {
        final KeyHolder keyId = new GeneratedKeyHolder();
        SqlParameterSource params = new MapSqlParameterSource("title", book.getTitle())
            .addValue("isbn", book.getIsbn())
            .addValue("price", book.getPrice());
        namedParameterJdbcTemplate.update(INSERT_BOOK, params, keyId);
        return keyId.getKey().intValue();
    }

    public void insertBookIntoInventory(Integer bookstoreId, Integer bookId, Integer quantity) {
        Map<String, Object> params = new HashMap<>();
        params.put("bookstore_id", bookstoreId);
        params.put("book_id", bookId);
        params.put("quantity", quantity);
        namedParameterJdbcTemplate.update(INSERT_BOOK_INTO_INVENTORY, params);
    }

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
