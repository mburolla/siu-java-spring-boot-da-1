package com.xpanxion.java.springboot.da1.demo.controller.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.response.BookStore;
import com.xpanxion.java.springboot.da1.demo.service.student3.DataService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class BookStoreController3 {

    @Autowired
    private DataService3 dataService3;

   @GetMapping("student3/api/v1/bookstores/{bookstoreId}/books")
   public List<BookStore> getInventory(@PathVariable int bookstoreId){
       return dataService3.getInventory(bookstoreId);
   }

}


