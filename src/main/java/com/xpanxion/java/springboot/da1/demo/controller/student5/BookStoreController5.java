package com.xpanxion.java.springboot.da1.demo.controller.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.InventoryItem;
import com.xpanxion.java.springboot.da1.demo.service.student5.DataAccessStudent5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookStoreController5 {

    @Autowired
    private DataAccessStudent5 dataAccess;

    @GetMapping("student5/api/v1/bookstores/{bookstoreId}/books")
    public List<InventoryItem> getBookstoreInventory(@PathVariable("bookstoreId") Integer bookstoreId) {
        return dataAccess.getBookstoreInventory(bookstoreId);
    }
}


