package com.xpanxion.java.springboot.da1.demo.controller.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.BookstoreBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookStoreController4 {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String SELECT_BOOK =  "select b.book_id, b.title, b.isbn, a.quantity, b.price, (quantity * price) AS total_price\n" +
                                        "from bookstore_book as a\n" +
                                        "join book as b on a.book_id = b.book_id\n" +
                                        "join bookstore as c on c.bookstore_id = a.bookstore_id\n" +
                                        "where a.bookstore_id = ?;";

    @GetMapping("student4/api/v1/bookstores/{bookstoreId}/books")
    public List<BookstoreBook> getBookstoreBooks(@PathVariable int bookstoreId) {
        List<BookstoreBook> bookstoreBooks;
        bookstoreBooks = jdbcTemplate.query(SELECT_BOOK, (row, rowNum) -> {
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
