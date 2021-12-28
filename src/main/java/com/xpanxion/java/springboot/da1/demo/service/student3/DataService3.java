package com.xpanxion.java.springboot.da1.demo.service.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.Book;
import com.xpanxion.java.springboot.da1.demo.model.student3.Manager;
import com.xpanxion.java.springboot.da1.demo.model.student3.response.BookStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class DataService3 {

    @Autowired
    private JdbcTemplate template;

    @Autowired
    private NamedParameterJdbcTemplate namedTemplate;

    private final String SELECT_BOOK = "select * from book where book_id = ?";
    private final String ADD_BOOK = """
      insert into book (title, isbn, price) 
      values (:title, :isbn, :price)
      """;
    private final String LINK_BOOK_BOOKSTORE = """
      insert into bookstore_book (bookstore_id, book_id, quantity) 
      values (:bookstore_id, :book_id, :quantity)
      """;
    private final String SELECT_INVENTORY = """
      select * from bookstore_book bsb
        join book b on b.book_id = bsb.book_id
        join bookstore bs on bsb.bookstore_id = bs.bookstore_id 
      where bs.bookstore_id = ?
      """;
    private final  String SELECT_MANAGER = "select * from manager";
    private final String INSERT_MANAGER = "insert into manager full_name values ?";
    private final String UPDATE_MANAGER = "update manager set full_name = ? where manager_id = ?";

    //
    //Gets
    //

    public String getMessage(){
        return "My name is Keith H. Inscore. " +
                "My favorite color is olive green. " +
                "My favorite band is Guns N' Roses. " +
                "For Christmas I got a gargantuan Tiamat and a KitchenAid.";
    }

    public List<Book> getBook(){
        int bookId = 1;
        List<Book> bookList;
        bookList = template.query(SELECT_BOOK, (row, rowNum) ->{
            var id = Integer.parseInt(row.getString("book_id"));
            var title = row.getString("title");
            var isbn = row.getString("isbn");
            var price = Double.parseDouble(row.getString("price"));
            return new Book(id, title, isbn, price);
        }, bookId);
        return bookList;
    }

    public List<BookStore> getInventory(@PathVariable int bookstoreId){
        List<BookStore> inventory;
        inventory = template.query(SELECT_INVENTORY, (row, rowNum) ->{
            var bookId = Integer.parseInt(row.getString("book_id"));
            var title = row.getString("title");
            var isbn = row.getString("isbn");
            var quantity = Integer.parseInt(row.getString("quantity"));
            var price = Double.parseDouble(row.getString("price"));
            BigDecimal totalPrice = new BigDecimal(quantity * price);
            return new BookStore(bookId, title, isbn, quantity, price, totalPrice);
        }, bookstoreId);
        return inventory;
    }

    public List<Manager> getManager(){
        List<Manager> managerList;
        managerList = template.query(SELECT_MANAGER, (row, rowNum) ->{
            var id = Integer.parseInt(row.getString("manager_id"));
            var fullName = row.getString("full_name");
            return new Manager(id, fullName);
        });
        return managerList;
    }

    //
    //Posts
    //

    public Book addBook (@RequestBody Book book, @PathVariable Integer bookstoreId, @RequestParam int quantity){
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("title", book.getTitle())
                .addValue("isbn", book.getIsbn())
                .addValue("price", book.getPrice());
        namedTemplate.update(ADD_BOOK, parameters, keyHolder);

        var bookId = keyHolder.getKey().intValue();

        MapSqlParameterSource bookstoreParameters = new MapSqlParameterSource()
                .addValue("bookstore_id", bookstoreId)
                .addValue("book_id", bookId)
                .addValue("quantity", quantity);
        namedTemplate.update(LINK_BOOK_BOOKSTORE, bookstoreParameters);
        book.setId(bookId);
        return book;
    }

    public Manager addManager(@RequestBody Manager manager){
        template.update(INSERT_MANAGER, manager.getFullName());
        return manager;
    }

    //
    //Puts
    //

    public Manager updateManagerName(@RequestBody Manager manager){
        template.update(UPDATE_MANAGER, manager.getFullName(), manager.getId());
        return manager;
    }
}
