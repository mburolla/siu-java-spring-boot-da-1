package com.xpanxion.java.springboot.da1.demo.controller.student5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController5 {

    @GetMapping("student5/api/v1/message")
    public String getMessage() {
        return "My name is Aaron D. Weegens.";
    }
}
