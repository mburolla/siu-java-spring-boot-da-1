package com.xpanxion.java.springboot.da1.demo.service.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.Book;
import com.xpanxion.java.springboot.da1.demo.model.student2.Manager;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import java.util.List;

@Service
public class DataAccessStudent2 {

    //
    // Data Members
    //

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private MapSqlParameterSource mapSqlParameterSource;
    private final String SELECT_BOOK = "select * from book where book_id = ?";
    private final String JOIN_BOOK_BOOKSTORE_BOOK = """
            select * 
            from bookstore_book bsb 
                join book b on b.book_id = bsb.book_id 
                join bookstore bs on bsb.bookstore_id = bs.bookstore_id 
            where bs.bookstore_id = ?
            """;
    private final String POST_BOOK = "insert into book (book_id, title, isbn, price) values (?, ?, ?, ?)";
    private final String GET_MANAGERS = "select * from manager";
    private final String POST_MANAGERS = "insert into manager (full_name) values (?)";
    private final String PUT_MANAGERS = "update manager set full_name = ? where manager_id = ?";

    //
    // Constructors
    //

    public DataAccessStudent2() {
        // Spring dependency injection (@Autowired) eliminates the need for us to create the jdbcTemplate:
        // DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        // dataSource.setUrl("jdbc:mysql://localhost:3306/marty");
        // dataSource.setUsername("root");
        // dataSource.setPassword("lU6mR3gO9qL8wY1b");
        // jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //
    // Methods
    //

    @GetMapping("student2/api/v1/book")
    public List<Book> getBook(Integer searchId) {
        List<Book> bookList;
        bookList = jdbcTemplate.query(SELECT_BOOK, (row, rowNum) -> {
            var book_id = Integer.parseInt(row.getString("book_id"));
            var title =  row.getString("title");
            var isbn =  row.getString("isbn");
            var price =  Double.parseDouble(row.getString("price"));
            return new Book(book_id, title, isbn, price);
        }, searchId);
        return bookList;
    }

    @GetMapping("student2/api/v1/bookstores/1/books")
    public List<Book> getBookstoreBooks(Integer bookstoreId) {
        List<Book> bookList;

        bookList = jdbcTemplate.query(JOIN_BOOK_BOOKSTORE_BOOK, (row, rowNum) -> {
            var book_id = Integer.parseInt(row.getString("book_id"));
            var title = row.getString("title");
            var isbn = row.getString("isbn");
            var price = Double.parseDouble(row.getString("price"));
            return new Book(book_id, title, isbn, price);
            }, bookstoreId);
        return bookList;
    }

    @PostMapping("student2/api/v1/bookstores/1/books")
    public void postBook(Book book) {
        jdbcTemplate.update(POST_BOOK, book.getId(), book.getTitle(), book.getIsbn(), book.getPrice());

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("book_id", book.getId());

        namedParameterJdbcTemplate.update("insert into bookstore_book (bookstore_id, book_id, quantity) values (1, :book_id, 1)", parameters);

    }

    @GetMapping("student2/api/v1/managers")
    public List<Manager> getManagers() {
        List<Manager> managerList;
        managerList = jdbcTemplate.query(GET_MANAGERS, (row, rowNum) -> {
            var manager_id = Integer.parseInt(row.getString("manager_id"));
            var full_name =  row.getString("full_name");
            return new Manager(manager_id, full_name);
        });
        return managerList;
    }

    @PostMapping("student2/api/v1/managers")
    public void postManagers(String full_name) {
        jdbcTemplate.update(POST_MANAGERS, full_name);
    }

    @PutMapping("student2/api/v1/managers")
    public void putManagers(String full_name, int manager_id) {
        jdbcTemplate.update(PUT_MANAGERS, full_name, manager_id);
    }
}