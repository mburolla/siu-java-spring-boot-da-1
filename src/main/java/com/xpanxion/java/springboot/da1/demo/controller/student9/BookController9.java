package com.xpanxion.java.springboot.da1.demo.controller.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Book;
import com.xpanxion.java.springboot.da1.demo.service.student9.DataServiceStudent9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BookController9 {

    @Autowired
    private DataServiceStudent9 dataAccess;

    @GetMapping("student9/api/v1/book")
    public Book getBook() {
        var temp = dataAccess.getBook(1);
        return temp;
    }


    @PostMapping("student9/api/v1/bookstores/{bookstoreId}/{quantity}/books")
    public void insertBook(@PathVariable Integer bookstoreId,@PathVariable Integer quantity, @RequestBody Book book){
        dataAccess.insertBook(bookstoreId,quantity,book);
    }

}


