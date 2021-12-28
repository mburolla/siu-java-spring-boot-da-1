package com.xpanxion.java.springboot.da1.demo.service.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.Book;
import com.xpanxion.java.springboot.da1.demo.model.student5.InventoryItem;
import com.xpanxion.java.springboot.da1.demo.model.student5.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataAccessStudent5 {

    //
    // Data Members
    //

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String SELECT_BOOKSTORE_BOOKS = "SELECT * FROM bookstore_book WHERE bookstore_id = ?";
    private final String SELECT_BOOK = "SELECT * FROM book WHERE book_id = ?";
    private final String INSERT_BOOK = "INSERT INTO book (title, isbn, price) VALUES (:title, :isbn, :price)";
    private final String INSERT_BOOK_INTO_INVENTORY = "INSERT INTO bookstore_book (bookstore_id, book_id, quantity) VALUES (:bookstore_id, :book_id, :quantity)";
    private final String SELECT_MANAGER = "select * from manager";
    private final String INSERT_MANAGER = "INSERT INTO manager (full_name) VALUES (?)";
    private final String UPDATE_MANAGER = "UPDATE manager SET full_name = (?) WHERE manager_id = (?)";

    //
    // Methods
    //

// Book Data Access
    public int insertBook(Book book) {
        final KeyHolder keyId = new GeneratedKeyHolder();
        SqlParameterSource params = new MapSqlParameterSource("title", book.getTitle())
                .addValue("isbn", book.getIsbn())
                .addValue("price", book.getPrice());
        namedParameterJdbcTemplate.update(INSERT_BOOK, params, keyId);
        return keyId.getKey().intValue();
    }

    public void insertBookIntoInventory(Integer bookstoreId, Integer bookId, Integer quantity) {
        SqlParameterSource params = new MapSqlParameterSource("bookstore_id", bookstoreId)
                .addValue("book_id", bookId)
                .addValue("quantity", quantity);
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

// Bookstore Data Access
    public List<InventoryItem> getBookstoreInventory(Integer bookstoreId) {
        List<InventoryItem> inventoryList;
        inventoryList = jdbcTemplate.query(SELECT_BOOKSTORE_BOOKS, (row, rowNum) -> {
            var id = Integer.parseInt(row.getString("book_id"));
            var quantity =  Integer.parseInt(row.getString("quantity"));
            return new InventoryItem(getBook(id).get(0), quantity);
        }, bookstoreId);
        return inventoryList;
    }

//Manager Data Access
    public List<Manager> getManagers() {
        List<Manager> managerList;
        managerList = jdbcTemplate.query(SELECT_MANAGER, (row, rowNum) -> {
            var id = Integer.parseInt(row.getString("manager_id"));
            var fullName =  row.getString("full_name");
            return new Manager(id, fullName);
        });
        return managerList;
    }

    public void updateManager(Manager manager) {
        jdbcTemplate.update(UPDATE_MANAGER, manager.getFullName(), manager.getManagerId());
    }

    public void insertManagers(Manager manager) {
        jdbcTemplate.update(INSERT_MANAGER, manager.getFullName());
    }
}
