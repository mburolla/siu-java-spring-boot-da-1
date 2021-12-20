package com.xpanxion.java.springboot.da1.demo.controller.student7;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController7 {

    @GetMapping("student7/api/v1/message")
    public String getMessage() {
        return "My name is Austin H.W. King, my favorite color is blue, and my favorite band is Led Zeppelin.";
    }
}
