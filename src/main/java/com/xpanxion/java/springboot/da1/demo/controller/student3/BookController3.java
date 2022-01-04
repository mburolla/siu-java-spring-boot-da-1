package com.xpanxion.java.springboot.da1.demo.controller.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.Book;
import com.xpanxion.java.springboot.da1.demo.service.student3.DataService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController3 {

    @Autowired
    private DataService3 dataService3;


    //
    //GetMap
    //

    @GetMapping("student3/api/v1/book")
    public List<Book> getBook() {
        return dataService3.getBook();
    }

    //
    //PostMap
    //

    @PostMapping("student3/api/v1/bookstores/{bookstoreId}/books")
    public Book addBook (@RequestBody Book book, @PathVariable Integer bookstoreId, @RequestParam int quantity){
        return dataService3.addBook(book, bookstoreId, quantity);
    }

    //
    //PutMap
    //

}
