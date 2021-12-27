package com.xpanxion.java.springboot.da1.demo.controller.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController1 {

    @Autowired
    private DataAccess dataAccess1;

    @GetMapping("student1/api/v1/book")
    public Book getBook() {
        return new Book(9, "title 9", "9999-999-999-999", 9.00);
    }

    @GetMapping("student1/api/v1/book/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        var bookList = dataAccess1.getBook(id);
        return bookList.get(0);
    }

    @PostMapping("student1/api/v1/bookstores/{bookstoreId}/books")
    public void insertBook(@PathVariable("bookstoreId") Integer bookstoreId, @RequestBody Book newBook) {
        dataAccess1.insertBook(newBook);
        dataAccess1.addToBookstore(newBook, bookstoreId);
    }

    @Service
    public static class DataAccess {
        @Autowired
        private JdbcTemplate jdbcTemplate;
        private final String SELECT_BOOK = "select * from book where book_id = ?";
        private final String SELECT_BOOK_BY_NAME = "SELECT * FROM book WHERE title = ?";
        private final String INSERT_BOOK = "insert into book (title, isbn, price, id) values (?,?,?,?)";
        private final String ADD_TO_BOOKSTORE = "insert into bookstore_book (bookstore_id, book_id, quantity) values (?,?,?)";

        public List<Book> getBook(Integer bookId) {
            List<Book> bookList;
            bookList = jdbcTemplate.query(SELECT_BOOK, (row, rowNum) -> {
                var id = Integer.parseInt(row.getString("book_id"));
                var title =  row.getString("title");
                var isbn = row.getString("isbn");
                var price = Double.parseDouble(row.getString("price"));

                return new Book(id, title, isbn, price);
            }, bookId);
            return bookList;
        }

        public void insertBook(Book newBook) {
            jdbcTemplate.update(INSERT_BOOK,
                    newBook.getTitle(),
                    newBook.getIsbn(),
                    newBook.getPrice(),
                    0);
        }

        public void addToBookstore(Book newBook, int bookstoreId) {
            List <Book> bookList;
            bookList = jdbcTemplate.query(SELECT_BOOK_BY_NAME, (row, column) -> {
                var id = Integer.parseInt(row.getString("book_id"));
                var title =  row.getString("title");
                var isbn = row.getString("isbn");
                var price = Double.parseDouble(row.getString("price"));

                return new Book(id, title, isbn, price);
            },newBook.getTitle());

            int bookId = bookList.get(0).getBook_id();
            jdbcTemplate.update(ADD_TO_BOOKSTORE, bookstoreId, bookId, 3 );
        }

    }

}
