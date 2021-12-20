package com.xpanxion.java.springboot.da1.demo.controller.student6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController6 {

    @GetMapping("student6/api/v1/message")
    public String getMessage() {
        return "My name is Michael";
    }
}
