package com.xpanxion.java.springboot.da1.demo.controller.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.Book;
import com.xpanxion.java.springboot.da1.demo.model.student7.BookstoreBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookstoreController7 {

    @Autowired
    JdbcTemplate jdbcTemplate;
    final String SELECT_BOOKSTORE_BOOK = """
            "SELECT bk.book_id, title, isbn, bsb.quantity, price\n" +
            " FROM book as bk INNER JOIN bookstore_book as bsb\n" +
            "ON bk.book_id = bsb.book_id\n" +
            "INNER JOIN bookstore bs\n" +
            "ON bsb.bookstore_id = bs.bookstore_id\n" +
            "WHERE bs.bookstore_id = ?"
            """;

    @GetMapping("student7/api/v1/bookstores/{bookstoreId}/books")
    public List<BookstoreBook> getPrice(@PathVariable int bookstoreId) {

        List<BookstoreBook> bookstoreList;

        bookstoreList = jdbcTemplate.query(SELECT_BOOKSTORE_BOOK, (rs, rowNum) -> {
            var bookId = Integer.parseInt(rs.getString("book_Id"));
            var title = rs.getString("title");
            var isbn = rs.getString("isbn");
            var quantity = Integer.parseInt(rs.getString("quantity"));
            var price = rs.getDouble("price");

            String priceString = "$" + Double.toString(price) + "0";

            double totalPriceNum = 0;
            totalPriceNum = price * quantity;
            String totalPrice = "$" + Double.toString(totalPriceNum) +"0";

            return new BookstoreBook(bookId, title, isbn, quantity, priceString, totalPrice);
        }, bookstoreId);
        return bookstoreList;
    }
}
