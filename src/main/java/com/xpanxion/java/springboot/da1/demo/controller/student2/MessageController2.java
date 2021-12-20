package com.xpanxion.java.springboot.da1.demo.controller.student2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController2 {

    @GetMapping("student2/api/v1/message")
    public String getMessage() {
        return "My name is Barrett Johnson.";
    }
}
