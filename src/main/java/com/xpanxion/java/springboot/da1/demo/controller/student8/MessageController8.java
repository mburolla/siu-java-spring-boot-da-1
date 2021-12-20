package com.xpanxion.java.springboot.da1.demo.controller.student8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController8 {

    @GetMapping("student8/api/v1/message")
    public String getMessage() {
        return "My name is Meg G.";
    }
}
