package com.xpanxion.java.springboot.da1.demo.service.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Book;
import com.xpanxion.java.springboot.da1.demo.model.student8.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService8 {

    // DATA

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // Query Strings for Book Controller

    private final String SELECT_BOOK_BY_ID = "select * from book where book_id = ?";
    private final String ADD_A_BOOK = "insert into book (title, isbn, price) VALUES (:title, :isbn, :price)";
    private final String ADD_BOOK_TO_BOOKSTORE = "insert into bookstore_book (bookstore_id, book_id, quantity) values (:bookstore_id, :book_id, :quantity)";

    // Query String for Bookstore Controller

    private final String SELECT_BOOKS_BY_BOOKSTORE = """
            select book.title, book.book_id, book.isbn, book.price, bookstore_book.quantity
            from book inner join bookstore_book
            where bookstore_book.book_id = book.book_id
            and bookstore_book.bookstore_id = ?""";

    // Query Strings for Manager Controller

    private final String SELECT_All_MANAGERS = "select * from manager";
    private final String ADD_A_MANAGER = "INSERT INTO MANAGER (full_name) VALUES (?)";
    private final String UPDATE_A_MANAGER = "UPDATE MANAGER SET full_name = ? where manager_id = ?";

    // CONSTRUCTOR

    public DataService8() {}

    // METHODS

    // for Book Controller

    public List<Book> getBook(Integer bookId) {
        List<Book> bookList;
        bookList = jdbcTemplate.query(SELECT_BOOK_BY_ID, (row, rowNum) -> {
            int id = Integer.parseInt(row.getString("book_id"));
            String title = row.getString("title");
            String isbn = row.getString("isbn");
            Double price = Double.parseDouble(row.getString("price"));
            return new Book(id, title, isbn, price);
        }, bookId);
        return bookList;
    }

    public void addBookToBookstore(Book book, Integer bookstoreID) {
        KeyHolder holder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("title", book.getTitle())
                .addValue("isbn", book.getIsbn())
                .addValue("price", book.getPrice())
                .addValue("bookstore_id", bookstoreID)
                .addValue("quantity", 1);
        namedParameterJdbcTemplate.update(ADD_A_BOOK, namedParameters, holder);
        book.setBookId(holder.getKey().intValue());
        namedParameters.addValue("book_id", book.getBookId());
        namedParameterJdbcTemplate.update(ADD_BOOK_TO_BOOKSTORE, namedParameters);
    }

    // for Bookstore Controller

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

    // for Manager Controller

    public List<Manager> getAllManagers() {
        List<Manager> listOfManagers;
        listOfManagers = jdbcTemplate.query(SELECT_All_MANAGERS, (row, rowNum) -> {
            int id = Integer.parseInt(row.getString("manager_id"));
            String name = row.getString("full_name");
            return new Manager(id, name);
        });
        return listOfManagers;
    }

    public void createManager(Manager manager) {
        jdbcTemplate.update(ADD_A_MANAGER, manager.getFullName());
    }

    public void updateManager(Manager manager) {
        jdbcTemplate.update(UPDATE_A_MANAGER, manager.getFullName(), manager.getId());
    }

}
