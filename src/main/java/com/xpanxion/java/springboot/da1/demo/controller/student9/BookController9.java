package com.xpanxion.java.springboot.da1.demo.controller.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BookController9 {
    @Autowired
    private DataAccess9 dataAccess;

    @GetMapping("student9/api/v1/book")
    public Book getBook() {
        var temp = dataAccess.getBook(1);
        return temp;
    }

    @PostMapping("student9/api/v1/bookstores/{bookstoreId}/{quantity}/books")
    public void insertBook(@PathVariable Integer bookstoreId,@PathVariable Integer quantity, @RequestBody Book book){
        dataAccess.insertBook(bookstoreId,quantity,book);
    }

}

@Service
 class DataAccess9 {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String SELECT_BOOK = "SELECT * FROM book WHERE book_id = ?";

    private final String GET_ID = "SELECT book_id FROM book WHERE title = ? AND isbn = ?";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String INSERT_BOOK = "INSERT INTO book (title,isbn,price) VALUES (:title, :isbn, :price)";
    private final String LINK_BOOK = "INSERT INTO bookstore_book (bookstore_id,book_id,quantity) VALUES (:bookstore_id, :book_id, :quantity)";

    Map<String, String> params = new HashMap<>();
    Map<String, Integer> bookstore_params = new HashMap<>();

    public void insertBook(int bookstoreId,int quantity, Book book) {
        params.put("title",book.getTitle());
        params.put("isbn",book.getIsbn());
        params.put("price", String.valueOf(book.getPrice()));
        namedParameterJdbcTemplate.update(INSERT_BOOK,params);

        var tempId = getBookId(book);


        bookstore_params.put("bookstore_id",bookstoreId);
        bookstore_params.put("book_id",tempId);
        bookstore_params.put("quantity",quantity);
        namedParameterJdbcTemplate.update(LINK_BOOK,bookstore_params);
    }

    public int getBookId(Book book){
        var bookId =  jdbcTemplate.query(GET_ID,(row,rowNum) -> {
            var id = Integer.parseInt(row.getString("book_id"));
            return getBook(id);
        },book.getTitle(),book.getIsbn());
        return bookId.get(0).getBook_id();
    }


    public DataAccess9() { }

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

