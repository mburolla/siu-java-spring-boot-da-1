package com.xpanxion.java.springboot.da1.demo.service.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Book;
import com.xpanxion.java.springboot.da1.demo.model.student4.BookstoreBook;
import com.xpanxion.java.springboot.da1.demo.model.student4.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
    public class DataServiceStudent4 {

        public DataServiceStudent4() {}

        @Autowired
        private JdbcTemplate jdbcTemplate;
        @Autowired
        private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String SELECT_BOOK = "select * from book where book_id = ?";
    private final String INSERT_BOOK = "insert into book (title, isbn, price) values (:title, :isbn, :price)";
    private final String LINK_BOOKSTORE = "insert into bookstore_book (bookstore_id, book_id, quantity) values (:bookstore_id, :book_id, :quantity)";

    private final String CHECK_BOOK =  """
                                       select b.book_id, b.title, b.isbn, a.quantity, b.price, (quantity * price) AS total_price
                                        from bookstore_book as a
                                        join book as b on a.book_id = b.book_id
                                        join bookstore as c on c.bookstore_id = a.bookstore_id
                                        where a.bookstore_id = ?
                                        """;
    private final String SELECT_MANAGER = "select * from manager";
    private final String INSERT_MANAGER = "insert into manager (full_name) values (?)";
    private final String UPDATE_MANAGER = "update Manager set full_name = ? where manager_id = ?";

    //BOOKSTORE CONTROLLER

    public List<BookstoreBook> getBookstoreBooks(@PathVariable int bookstoreId) {
        List<BookstoreBook> bookstoreBooks;
        bookstoreBooks = jdbcTemplate.query(CHECK_BOOK, (row, rowNum) -> {
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

    public List<Book> getBook() {
        int bookId = 1;
        List<Book> bookList;
        bookList = jdbcTemplate.query(SELECT_BOOK, (row, rowNum) -> {
        int id = Integer.parseInt(row.getString("book_id"));
        String title = row.getString("title");
        String isbn = row.getString("isbn");
        Double price = Double.parseDouble(row.getString("price"));
        return new Book(id, title, isbn, price);
        }, bookId);
        return bookList;
        }


    public Book insertBook(@PathVariable int bookstoreId, @RequestBody Book book) {
        final KeyHolder keyId = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new MapSqlParameterSource("title", book.getTitle())
        .addValue("isbn", book.getIsbn())
        .addValue("price", book.getPrice());
        namedParameterJdbcTemplate.update(INSERT_BOOK, namedParameters, keyId);

        SqlParameterSource bookstore_bookValues = new MapSqlParameterSource("bookstore_id", bookstoreId)
        .addValue("book_id", keyId.getKey())
        .addValue("quantity", 1);
        namedParameterJdbcTemplate.update(LINK_BOOKSTORE, bookstore_bookValues);
        book.setId(keyId.getKey().intValue());
        return book;
        }

        //MANAGER CONTROLLER

    public List<Manager> getManager() {
        List<Manager> managerList;
        managerList = jdbcTemplate.query(SELECT_MANAGER, (row, rowNum) -> {
            int id = Integer.parseInt(row.getString("manager_id"));
            String name= row.getString("full_name");
            return new Manager(id, name);
        });
        return managerList;
    }

    public Manager insertManager(@RequestBody Manager manager) {
        jdbcTemplate.update(INSERT_MANAGER, manager.getName());
        return manager;
    }

    public Manager updateManager(@RequestBody Manager manager) {
        jdbcTemplate.update(UPDATE_MANAGER, manager.getName(), manager.getId());
        return manager;
    }
}