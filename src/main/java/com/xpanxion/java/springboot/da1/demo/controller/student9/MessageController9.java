package com.xpanxion.java.springboot.da1.demo.controller.student9;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController9 {

    @GetMapping("student9/api/v1/message")
    public String getMessage() {
        return "My name is Emanuel C Garcia. My favorite color is Red. My favorite band is All Time Low. For Christmas i received a new mouse and a homepod mini";
    }
}
