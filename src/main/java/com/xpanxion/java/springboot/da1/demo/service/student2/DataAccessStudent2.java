package com.xpanxion.java.springboot.da1.demo.service.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.Book;
import com.xpanxion.java.springboot.da1.demo.model.student2.Manager;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Service
public class DataAccessStudent2 {

    //
    // Data Members
    //

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String SELECT_BOOK = "select * from book where book_id = ?";
    private final String GET_MANAGERS = "select * from manager";
    private final String POST_MANAGERS = "insert into manager (full_name) values (?)";

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
}