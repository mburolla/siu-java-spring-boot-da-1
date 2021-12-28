package com.xpanxion.java.springboot.da1.demo.controller.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.BookstoreBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookstoreController1 {

    @Autowired
    DataAccess1 dataAccess1;

    @GetMapping("student1/api/v1/bookstores/{bookstoreId}/books")
    public List<BookstoreBook> getBookstoreBooks(@PathVariable("bookstoreId") int bookstoreId) {

        var bookstoreBooks = dataAccess1.getBookstoreBooks(bookstoreId);
        return bookstoreBooks;

    }

    @Service
    public static class DataAccess1 {

        @Autowired
        JdbcTemplate jdbcTemplate;

        private final String GET_BOOKSTORE_BOOKS =
                "select b.book_id, b.title, b.isbn, bsb.quantity, b.price, (quantity * price) AS total_price\n" +
                "from bookstore_book as bsb\n" +
                "join book as b on bsb.book_id = b.book_id\n" +
                "join bookstore as bs on bs.bookstore_id = bsb.bookstore_id\n" +
                "where bsb.bookstore_id = ?;";

        public List<BookstoreBook> getBookstoreBooks(int bookstoreId) {

            List<BookstoreBook> bookstoreBooks;

            bookstoreBooks = jdbcTemplate.query(GET_BOOKSTORE_BOOKS, (row, rowNum) -> {
                var book_id = Integer.parseInt(row.getString("book_id"));
                var title = row.getString("title");
                var isbn = row.getString("isbn");
                var quantity = Integer.parseInt(row.getString("quantity"));
                var price = Double.parseDouble(row.getString("price"));
                var total_price = Double.parseDouble(row.getString("total_price"));

                return new BookstoreBook(book_id, title, isbn, quantity, price, total_price);

            }, bookstoreId);

            return bookstoreBooks;

        }

    }

}
