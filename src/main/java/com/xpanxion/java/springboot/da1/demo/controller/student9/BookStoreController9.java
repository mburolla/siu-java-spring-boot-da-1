package com.xpanxion.java.springboot.da1.demo.controller.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Book;
import com.xpanxion.java.springboot.da1.demo.model.student9.BookInventoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookStoreController9 {
    @Autowired
    private DataAccessStudent9 dataAccess;

    @GetMapping("student9/api/v1/bookstores/{bookstoreId}/books")
    public List<BookInventoryBook> getBookStoreInventory(@PathVariable Integer bookstoreId) {
        return dataAccess.getBookStoreInventory(bookstoreId);

    }
}

@Service
class DataAccessStudent9 {

    public DataAccessStudent9() {}
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String SELECT_INVENTORY = "SELECT b.book_id, title, isbn, quantity, price, (quantity * price) AS 'total_price' from book b JOIN bookstore_book bs ON b.book_id = bs.book_id JOIN bookstore bm ON bs.bookstore_id = bm.bookstore_id WHERE bm.bookstore_id = ?";

    public List<BookInventoryBook> getBookStoreInventory(int bookstoreId) {
        List<BookInventoryBook> bookInventoryBookList;
        bookInventoryBookList = jdbcTemplate.query(SELECT_INVENTORY, (row, rowNum) -> {
            var id = Integer.parseInt(row.getString("book_id"));
            var title = row.getString("title");
            var isbn = row.getString("isbn");
            var quantity = Integer.parseInt(row.getString("quantity"));
            var price = Double.parseDouble(row.getString("price"));
            var totalPrice = Double.parseDouble(row.getString("total_price"));
            return new BookInventoryBook(id, title, isbn, quantity, price, totalPrice);
        }, bookstoreId);

        if (bookInventoryBookList.isEmpty()) {
            System.out.println("List is empty");
            return null;
        } else {
            return bookInventoryBookList;
        }
    }
}

