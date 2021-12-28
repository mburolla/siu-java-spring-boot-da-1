package com.xpanxion.java.springboot.da1.demo.service.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.Book;
import com.xpanxion.java.springboot.da1.demo.model.student7.BookstoreBook;
import com.xpanxion.java.springboot.da1.demo.model.student7.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class DataService7 {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String SELECT_MANAGERS = "select * from manager";
    private final String INSERT_MANAGER = "insert into student7_da.manager(full_name) Values (?)";
    private final String UPDATE_MANAGER = "UPDATE manager SET full_name= ? WHERE manager_id= ?";
    private final String SELECT_BOOK = "select * from book where book_id = ?";
    private final String INSERT_BOOK = "INSERT INTO book(title, isbn, price) Values (:title, :isbn, :price)";
    private final String LINK_BOOKSTORE = "INSERT INTO bookstore_book(bookstore_id, book_id,quantity) VALUES (:bookstoreId,:bookId,:quantity)";
    private final String SELECT_BOOKSTORE_BOOK = """
            "SELECT bk.book_id, title, isbn, bsb.quantity, price
            " +
            " FROM book as bk INNER JOIN bookstore_book as bsb
            " +
            "ON bk.book_id = bsb.book_id
            " +
            "INNER JOIN bookstore bs
            " +
            "ON bsb.bookstore_id = bs.bookstore_id
            " +
            "WHERE bs.bookstore_id = ?"
            """;
//    Returns a book from database
    public List<Book> getBook() {
        int numOfBook = 1;
        List<Book> bookList;
        bookList = jdbcTemplate.query(SELECT_BOOK, (rs, rowNum) -> {
            var bookId = Integer.parseInt(rs.getString("book_Id"));
            var title = rs.getString("title");
            var isbn = rs.getString("isbn");
            var price = rs.getDouble("price");
            return new Book(bookId, title, isbn, price);
        },numOfBook);
        return bookList;
    }
//      Creates a book in database and links book id to a bookstore id
    @PostMapping("Student7/api/v1/bookstores/{bookstoreId}/books")
    public void insertBook(@PathVariable int bookstoreId, @RequestBody Book Book) {
        final KeyHolder keyId = new GeneratedKeyHolder();

        SqlParameterSource namedParameters = new MapSqlParameterSource("title", Book.getTitle())
                .addValue("isbn", Book.getIsbn())
                .addValue("price", Book.getPrice());
        namedParameterJdbcTemplate.update(INSERT_BOOK, namedParameters,keyId);

        SqlParameterSource bookstoreParameters = new MapSqlParameterSource("bookstoreId", bookstoreId)
                .addValue("bookId", keyId.getKey().intValue())
                .addValue("quantity", 1);
        namedParameterJdbcTemplate.update(LINK_BOOKSTORE, bookstoreParameters);
    }
//      Finds all books at bookstore Id and shows price based on quantity
    @GetMapping("student7/api/v1/bookstores/{bookstoreId}/books")
    public List<BookstoreBook> getPrice(@PathVariable int bookstoreId) {

        List<BookstoreBook> bookstoreList;

        bookstoreList = jdbcTemplate.query(SELECT_BOOKSTORE_BOOK, (rs, rowNum) -> {
            var bookId = Integer.parseInt(rs.getString("book_Id"));
            var title = rs.getString("title");
            var isbn = rs.getString("isbn");
            var quantity = Integer.parseInt(rs.getString("quantity"));
            var price = rs.getDouble("price");

            String priceString = "$" + Double.toString(price) + "0";

            double totalPriceNum = 0;
            totalPriceNum = price * quantity;
            String totalPrice = "$" + Double.toString(totalPriceNum) +"0";

            return new BookstoreBook(bookId, title, isbn, quantity, priceString, totalPrice);
        }, bookstoreId);
        return bookstoreList;
    }
//      Returns a list of managers
    public List<Manager> getManagers() {
        List<Manager> managers;
        managers = jdbcTemplate.query(SELECT_MANAGERS, (rs, rowNum) -> {
            var managerId = Integer.parseInt(rs.getString("manager_id"));
            var managerName = rs.getString("full_name");
            return new Manager(managerId, managerName);
        });
        return managers;
    }
//    Inserts new manager into database
    public Manager insertManager(@RequestBody Manager manager) {
        jdbcTemplate.update(INSERT_MANAGER, manager.getFullName());
        return manager;
    }
//    Updates manager in database
    public Manager updateManager(@RequestBody Manager manager) {
        jdbcTemplate.update(UPDATE_MANAGER, manager.getFullName(), manager.getId());
        return manager;
    }
}
