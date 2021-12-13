package com.xpanxion.java.springboot.da1.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Student8Controller {

    @GetMapping("student8/api/v1/message")
    public String getMessage() {
        return "My name is ...";
    }
}
