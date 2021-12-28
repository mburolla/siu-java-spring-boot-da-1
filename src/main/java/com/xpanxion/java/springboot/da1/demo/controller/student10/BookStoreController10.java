package com.xpanxion.java.springboot.da1.demo.controller.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.Bookstore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookStoreController10 {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String SELECT_BOOKSTORE_BOOK = """
                            select b.book_id, title, isbn, bsb.quantity, price, price * bsb.quantity as total_price
                            from book as b inner join bookstore_book as bsb
                            on b.book_id = bsb.book_id
                            inner join bookstore bs
                            on bsb.bookstore_id = bs.bookstore_id
                            where bs.bookstore_id = ?""";

    @GetMapping ("student10/api/v1/bookstores/{bookstoreId}/books")
    public List<Bookstore> getBooks(@PathVariable int bookstoreId){
        List<Bookstore> bookList;
        bookList = jdbcTemplate.query(SELECT_BOOKSTORE_BOOK, (row, rowNum) -> {
            var id = Integer.parseInt(row.getString("book_id"));
            var title =  row.getString("title");
            var isbn = row.getString("isbn");
            var quantity = Integer.parseInt(row.getString("quantity"));
            var price = Double.parseDouble(row.getString("price"));
            var totalPrice = Double.parseDouble(row.getString("total_price"));
            return new Bookstore(id, title, isbn, quantity, price, totalPrice);
        }, bookstoreId);
        return bookList;
    }
}
