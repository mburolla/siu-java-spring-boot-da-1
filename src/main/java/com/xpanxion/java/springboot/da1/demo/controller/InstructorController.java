package com.xpanxion.java.springboot.da1.demo.controller;

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
        // instructorDataService.addProduct();
        // var pList = instructorDataService.getProducts();
        return "My name is Marty.";
    }

    //
    // Product
    //



}
