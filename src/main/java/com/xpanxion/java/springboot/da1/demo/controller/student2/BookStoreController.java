package com.xpanxion.java.springboot.da1.demo.controller.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.Book;
import com.xpanxion.java.springboot.da1.demo.service.student2.DataAccessStudent2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookStoreController {

    @Autowired
    private DataAccessStudent2 dataAccess;

    @GetMapping("student2/api/v1/bookstores/1/books")
    public List<Book> getBookstoreBooks() {
        int count = 0;

        var bookList = dataAccess.getBookstoreBooks(1);
        for (Book n : bookList) {
            if(count == 0) {
                n.setTotalPrice(n.getPrice());
            } else {
                n.setTotalPrice(n.getPrice() + bookList.get(count - 1).getTotalPrice());
            }
            count += 1;
        }
        return bookList;
    }

}
