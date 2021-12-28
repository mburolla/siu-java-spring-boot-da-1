package com.xpanxion.java.springboot.da1.demo.service.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.Book;
import com.xpanxion.java.springboot.da1.demo.model.student10.Bookstore;
import com.xpanxion.java.springboot.da1.demo.model.student10.Manager;
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
public class DataService10 {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String SELECT_BOOK = "select * from book where book_id = ?";
    private final String INSERT_BOOK = "insert into book (title, isbn, price) values (:title, :isbn, :price)";
    private final String INSERT_BOOK_BOOKSTORE = "insert into bookstore_book (bookstore_id, book_id, quantity) values (:bookstore_id, :book_id, :quantity)";
    private final String SELECT_BOOKSTORE_BOOK = """
                            select b.book_id, title, isbn, bsb.quantity, price, price * bsb.quantity as total_price
                            from book as b inner join bookstore_book as bsb
                            on b.book_id = bsb.book_id
                            inner join bookstore bs
                            on bsb.bookstore_id = bs.bookstore_id
                            where bs.bookstore_id = ?""";
    private final String SELECT_MANAGER = "select * from manager";
    private final String INSERT_MANAGER = "insert into manager (full_name) values (?)";
    private final String UPDATE_MANAGER = "update manager set full_name = ? where manager_id = ?";

    public List<Book> getBook(){
        List<Book> bookList;
        bookList = jdbcTemplate.query(SELECT_BOOK, (row, rowNum) -> {
            var id = Integer.parseInt(row.getString("book_id"));
            var title =  row.getString("title");
            var isbn = row.getString("isbn");
            var price = Double.parseDouble(row.getString("price"));
            return new Book(id, title, isbn, price);
        }, 3);
        return bookList;
    }

    public Book addBook(Book book, int quantity, int bookstoreId){
        final KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new MapSqlParameterSource("title", book.getTitle())
                .addValue("isbn", book.getIsbn())
                .addValue("price", book.getPrice());
        namedParameterJdbcTemplate.update(INSERT_BOOK, namedParameters, holder);
        int bookId = holder.getKey().intValue();
        addBookBookStore(bookId, quantity, bookstoreId);
        book.setId(bookId);
        return book;
    }

    public List<Bookstore> getBooks(int bookstoreId) {
        List<Bookstore> bookList;
        bookList = jdbcTemplate.query(SELECT_BOOKSTORE_BOOK, (row, rowNum) -> {
            var id = Integer.parseInt(row.getString("book_id"));
            var title = row.getString("title");
            var isbn = row.getString("isbn");
            var quantity = Integer.parseInt(row.getString("quantity"));
            var price = Double.parseDouble(row.getString("price"));
            var totalPrice = Double.parseDouble(row.getString("total_price"));
            return new Bookstore(id, title, isbn, quantity, price, totalPrice);
        }, bookstoreId);
        return bookList;
    }

    public List<Manager> getManagers () {
        List<Manager> managerList;
        managerList = jdbcTemplate.query(SELECT_MANAGER, (row, rowNum) -> {
            var id = Integer.parseInt(row.getString("manager_id"));
            var name =  row.getString("full_name");
            return new Manager(id, name);
        });
        return managerList;
    }

    public Manager addManager (Manager manager) {
        jdbcTemplate.update(INSERT_MANAGER, (manager.getFull_name()));
        return manager;
    }

    public Manager updateManager (Manager manager){
        jdbcTemplate.update(UPDATE_MANAGER, manager.getFull_name(), manager.getManager_id());
        return manager;
    }

    //Helper Functions
    private void addBookBookStore(int bookId, int quantity, int bookstoreId){
        SqlParameterSource namedParameters = new MapSqlParameterSource("book_id", bookId)
                .addValue("bookstore_id", bookstoreId)
                .addValue("quantity", quantity);
        namedParameterJdbcTemplate.update(INSERT_BOOK_BOOKSTORE, namedParameters);
    }
}
