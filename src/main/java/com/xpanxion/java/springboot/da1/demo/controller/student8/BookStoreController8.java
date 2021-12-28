package com.xpanxion.java.springboot.da1.demo.controller.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookStoreController8 {

    @Autowired
    private DataAccess8 dataAccess;

    @GetMapping("student8/api/v1/bookstores/{bookstoreId}/books")
    public List<Book> getBooksInBookstore(@PathVariable("bookstoreId") Integer id) {
        var bookList = dataAccess.getBooksInBookstore(id);
        return bookList;
    }

    @Service
    static class DataAccess8 {

        // DATA

        @Autowired
        private JdbcTemplate jdbcTemplate;
        private final String SELECT_BOOKS_BY_BOOKSTORE = """
            select book.title, book.book_id, book.isbn, book.price, bookstore_book.quantity
            from book inner join bookstore_book
            where bookstore_book.book_id = book.book_id
            and bookstore_book.bookstore_id = ?""";

        // CONSTRUCTOR

        public DataAccess8() {}

        // METHODS

        public List<Book> getBooksInBookstore(Integer bookstoreId) {
            List<Book> booksInBookstore;
            booksInBookstore = jdbcTemplate.query(SELECT_BOOKS_BY_BOOKSTORE, (row, rowNum) -> {
                int bookID = Integer.parseInt(row.getString("book_id"));
                String title = row.getString("title");
                String isbn = row.getString("isbn");
                int quantity = Integer.parseInt(row.getString("quantity"));
                Double price = Double.parseDouble(row.getString("price"));
                Double totalCost = price * quantity;
                return new Book(bookID, title, isbn, quantity, price, totalCost);
            }, bookstoreId);
            return booksInBookstore;
        }

    }

}
