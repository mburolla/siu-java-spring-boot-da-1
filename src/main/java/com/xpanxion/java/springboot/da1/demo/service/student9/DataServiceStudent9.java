package com.xpanxion.java.springboot.da1.demo.service.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Book;
import com.xpanxion.java.springboot.da1.demo.model.student9.BookInventoryBook;
import com.xpanxion.java.springboot.da1.demo.model.student9.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataServiceStudent9 {

    public DataServiceStudent9() {}

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // Query Statements
    private final String SELECT_INVENTORY =
            """
                    SELECT b.book_id, title, isbn, quantity, price, (quantity * price) AS 'total_price'
                    from book b JOIN bookstore_book bs ON b.book_id = bs.book_id JOIN bookstore bm ON bs.bookstore_id = bm.bookstore_id
                    WHERE bm.bookstore_id = ?
                    """;
    private final String SELECT_BOOK = "SELECT * FROM book WHERE book_id = ?";

    private final String INSERT_BOOK = "INSERT INTO book (title,isbn,price) VALUES (:title, :isbn, :price)";

    private final String LINK_BOOK = "INSERT INTO bookstore_book (bookstore_id,book_id,quantity) VALUES (:bookstore_id, :book_id, :quantity)";

    private final String SELECT_ALL_MANAGERS = "SELECT * FROM manager";

    private final String INSERT_MANAGER = "INSERT INTO manager (full_name) VALUES (?)";

    private final String UPDATE_MANAGER = "UPDATE manager SET full_name = ? WHERE manager_id = ?";


    // BookStore Controller Methods
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

    // Book Controller Methods
    Map<String, String> params = new HashMap<>();
    Map<String, Integer> bookstore_params = new HashMap<>();

    public void insertBook(int bookstoreId,int quantity, Book book) {
        params.put("title",book.getTitle());
        params.put("isbn",book.getIsbn());
        params.put("price", String.valueOf(book.getPrice()));

        MapSqlParameterSource tempParams = new MapSqlParameterSource().addValues(params);
        final KeyHolder holder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(INSERT_BOOK, tempParams,holder, new String[]{"book_id"});


        var tempId = Integer.parseInt(String.valueOf(holder.getKey()));

        bookstore_params.put("bookstore_id",bookstoreId);
        bookstore_params.put("book_id", tempId);
        bookstore_params.put("quantity",quantity);
        namedParameterJdbcTemplate.update(LINK_BOOK,bookstore_params);
    }

    public Book getBook(int bookId) {

        var book = jdbcTemplate.query(SELECT_BOOK, (row, rowNum) -> {
            var id = Integer.parseInt(row.getString("book_id"));
            var title =  row.getString("title");
            var isbn = row.getString("isbn");
            var price = Double.parseDouble(row.getString("price"));
            return new Book(id, title,isbn,price);
        }, bookId);

        if(book.get(0) == null){
            System.out.println("No Book found");
            return null;
        } else {
            return book.get(0);
        }
    }

    //Manager Controller
    public void updateManager(Manager manager){
        jdbcTemplate.update(UPDATE_MANAGER,manager.getFull_name(),manager.getId());
    }

    public void addManager(Manager manager){
        jdbcTemplate.update(INSERT_MANAGER,manager.getFull_name());
    }

    public List<Manager> getManagerList() {
        List<Manager> managerList;
        managerList = jdbcTemplate.query(SELECT_ALL_MANAGERS, (row,rowNum) -> {
            var id = Integer.parseInt(row.getString("manager_id"));
            var full_name = row.getString("full_name");
            return new Manager(id,full_name);
        });
        return managerList;
    }

}
