package com.xpanxion.java.springboot.da1.demo.controller.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.response.BookStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

@RestController
public class BookStoreController3 {

    @Autowired
    private JdbcTemplate template;

    private final String SELECT_INVENTORY = """
      select *
      from bookstore_book bsb
        join book b on b.book_id = bsb.book_id
        join bookstore bs on bsb.bookstore_id = bs.bookstore_id 
      where bs.bookstore_id = ?
      """;

   @GetMapping("student3/api/v1/bookstores/{bookstoreId}/books")
   public List<BookStore> getInventory(@PathVariable int bookstoreId){
       NumberFormat formatter = NumberFormat.getCurrencyInstance();

       List<BookStore> inventory;
       inventory = template.query(SELECT_INVENTORY, (row, rowNum) ->{
           var bookId = Integer.parseInt(row.getString("book_id"));
           var title = row.getString("title");
           var isbn = row.getString("isbn");
           var quantity = Integer.parseInt(row.getString("quantity"));
           var price = Double.parseDouble(row.getString("price"));
           BigDecimal totalPrice = new BigDecimal(quantity * price);
           return new BookStore(bookId,title,isbn,quantity,price,totalPrice);
       }, bookstoreId);
    return inventory;
   }

}


