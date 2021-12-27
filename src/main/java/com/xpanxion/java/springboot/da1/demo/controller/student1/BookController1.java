package com.xpanxion.java.springboot.da1.demo.controller.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Book;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController1 {

    @Autowired
    private DataAccess dataAccess1;

    @GetMapping("student1/api/v1/book")
    public Book getBook() {
        return new Book(9, "title 9", "9999-999-999-999", 9.00);
    }

    @GetMapping("student1/api/v1/book/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        var bookList = dataAccess1.getBook(id);
        return bookList.get(0);
    }

    @PostMapping("student1/api/v1/bookstores/{bookstoreId}/books")
    public void insertBook(@PathVariable("bookstoreId") Integer bookstoreId, @RequestBody Book newBook) {
        int bookId = dataAccess1.insertBook(newBook);
        dataAccess1.addToBookstore(newBook, bookstoreId, bookId);
    }

    @Service
    public static class DataAccess {
        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Autowired
        private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

        private KeyHolder holder = new GeneratedKeyHolder();
        private final String SELECT_BOOK = "select * from book where book_id = ?";
        private final String SELECT_BOOK_BY_NAME = "SELECT * FROM book WHERE title = ?";
        private final String INSERT_BOOK =
                "insert into book (title, isbn, price) values (:title, :isbn, :price)";
        private final String ADD_TO_BOOKSTORE =
                "insert into bookstore_book (bookstore_id, book_id, quantity) values (:bookstore_id, :book_id, :quantity)";

        public List<Book> getBook(Integer bookId) {
            List<Book> bookList;
            bookList = jdbcTemplate.query(SELECT_BOOK, (row, rowNum) -> {
                var id = Integer.parseInt(row.getString("book_id"));
                var title =  row.getString("title");
                var isbn = row.getString("isbn");
                var price = Double.parseDouble(row.getString("price"));

                return new Book(id, title, isbn, price);
            }, bookId);
            return bookList;
        }

        public int insertBook(Book newBook) {
            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue("title", newBook.getTitle())
                    .addValue("isbn", newBook.getIsbn())
                    .addValue("price", newBook.getPrice());

            namedParameterJdbcTemplate.update(INSERT_BOOK, parameters, holder);
            return holder.getKey().intValue();
        }

        public Book addToBookstore(Book newBook, int bookstoreId, int bookId) {
//            List <Book> bookList;
//            bookList = jdbcTemplate.query(SELECT_BOOK_BY_NAME, (row, column) -> {
//                var id = Integer.parseInt(row.getString("book_id"));
//                var title =  row.getString("title");
//                var isbn = row.getString("isbn");
//                var price = Double.parseDouble(row.getString("price"));
//
//                return new Book(id, title, isbn, price);
//            },newBook.getTitle());
//
//            int bookId = bookList.get(0).getBook_id();
//            jdbcTemplate.update(ADD_TO_BOOKSTORE, bookstoreId, bookId, 3 );

            MapSqlParameterSource bookstore_parameters = new MapSqlParameterSource()
                    .addValue("bookstore_id", bookstoreId)
                    .addValue("book_id", bookId)
                    .addValue("quantity", 2);

            namedParameterJdbcTemplate.update(ADD_TO_BOOKSTORE, bookstore_parameters);
            newBook.setBook_id(bookId);
            return newBook;
        }

    }

}
