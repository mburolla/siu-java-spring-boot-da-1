package com.xpanxion.java.springboot.da1.demo.controller;

import java.util.List;
import com.xpanxion.java.springboot.da1.demo.model.Product;
import com.xpanxion.java.springboot.da1.demo.service.InstructorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructorController {

    @Autowired
    private InstructorDataService instructorDataService;

    //
    // Message
    //

    @GetMapping("instructor/api/v1/message")
    public String getMessage() {
        return "My name is Marty.";
    }

    //
    // Product
    //

    @GetMapping("instructor/api/v1/products")
    public List<Product> getProducts() {
        var productList = instructorDataService.getProducts();
        return productList;
    }
}
