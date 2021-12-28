package com.xpanxion.java.springboot.da1.demo.controller.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.Book;
import com.xpanxion.java.springboot.da1.demo.service.student5.DataAccessStudent5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController5 {

    @Autowired
    private DataAccessStudent5 dataAccess;

    @GetMapping("student5/api/v1/book")
    public Book getBook() {
        return new Book(1, "This is a book", "1111-111-111-1111", 9.99);
    }

    @GetMapping("student5/api/v1/book/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        var book = dataAccess.getBook(id);
        return book.get(0);
    }

    @PostMapping("student5/api/v1/bookstores/{bookstoreId}/books")
    public void insertBook(@PathVariable("bookstoreId") Integer bookstoreId, @RequestBody Book book) {
        var bookId = dataAccess.insertBook(book);
        dataAccess.insertBookIntoInventory(bookstoreId,bookId,1);
    }
}
