package com.xpanxion.java.springboot.da1.demo.controller;

import com.xpanxion.java.springboot.da1.demo.service.InstructorDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructorController {

    @GetMapping("instructor/api/v1/message")
    public String getMessage() {

        var ids = new InstructorDataService();
        var pList = ids.getProducts();
        return "My name is Marty.";
    }
}
