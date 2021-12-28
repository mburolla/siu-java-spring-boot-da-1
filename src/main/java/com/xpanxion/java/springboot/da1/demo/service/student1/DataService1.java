package com.xpanxion.java.springboot.da1.demo.service.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Book;
import com.xpanxion.java.springboot.da1.demo.model.student1.BookstoreBook;
import com.xpanxion.java.springboot.da1.demo.model.student1.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService1 {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Autowired
        private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

        private final String SELECT_BOOK = "select * from book where book_id = ?";
        private final String SELECT_BOOK_BY_NAME = "SELECT * FROM book WHERE title = ?";
        private final String INSERT_BOOK =
                "insert into book (title, isbn, price) values (:title, :isbn, :price)";
        private final String ADD_TO_BOOKSTORE =
                "insert into bookstore_book (bookstore_id, book_id, quantity) values (:bookstore_id, :book_id, :quantity)";
        private final String GET_BOOKSTORE_BOOKS =
                """
                select b.book_id, b.title, b.isbn, bsb.quantity, b.price, (quantity * price) AS total_price
                from bookstore_book as bsb 
                join book as b on bsb.book_id = b.book_id
                join bookstore as bs on bs.bookstore_id = bsb.bookstore_id
                where bsb.bookstore_id = ?
                
                """;
        private final String SELECT_MANAGERS = "select * from manager";
        private final String UPDATE_MANAGER = "update manager set full_name = ? where manager_id = ?";
        private final String INSERT_MANAGER = "insert into manager (full_name) values (?)";

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

        public int insertBook(Book newBook) {
            KeyHolder holder = new GeneratedKeyHolder();

            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue("title", newBook.getTitle())
                    .addValue("isbn", newBook.getIsbn())
                    .addValue("price", newBook.getPrice());

            namedParameterJdbcTemplate.update(INSERT_BOOK, parameters, holder);
            return holder.getKey().intValue();
        }

        public Book addToBookstore(Book newBook, int bookstoreId, int bookId) {
            MapSqlParameterSource bookstore_parameters = new MapSqlParameterSource()
                    .addValue("bookstore_id", bookstoreId)
                    .addValue("book_id", bookId)
                    .addValue("quantity", 2);

            namedParameterJdbcTemplate.update(ADD_TO_BOOKSTORE, bookstore_parameters);
            newBook.setBook_id(bookId);
            return newBook;
        }

        public List<BookstoreBook> getBookstoreBooks(int bookstoreId) {

            List<BookstoreBook> bookstoreBooks;

            bookstoreBooks = jdbcTemplate.query(GET_BOOKSTORE_BOOKS, (row, rowNum) -> {
                var bookId = Integer.parseInt(row.getString("book_id"));
                var title = row.getString("title");
                var isbn = row.getString("isbn");
                var quantity = Integer.parseInt(row.getString("quantity"));
                var price = Double.parseDouble(row.getString("price"));
                var totalPrice = Double.parseDouble(row.getString("total_price"));

                return new BookstoreBook(bookId, title, isbn, quantity, price, totalPrice);

            }, bookstoreId);

            return bookstoreBooks;

    }

        public List<Manager> getManagers() {
            List<Manager> managersList;
            managersList = jdbcTemplate.query(SELECT_MANAGERS, (row, rowNum) -> {
                var id = Integer.parseInt(row.getString("manager_id"));
                var fullName = row.getString("full_name");

                return new Manager(id, fullName);
            });
            return managersList;
        }

        public void updateManager(Manager manager) {
            jdbcTemplate.update(UPDATE_MANAGER, manager.getFullName(), manager.getManagerId());
        }

        public void insertManager(Manager manager) {
        jdbcTemplate.update(INSERT_MANAGER, manager.getFullName());
    }


}
