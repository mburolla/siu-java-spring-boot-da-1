package com.xpanxion.java.springboot.da1.demo.controller.student10;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController10 {

    @GetMapping("student10/api/v1/message")
    public String getMessage() {
        return "My name is Rachel K Eckels, and my favorite color is green. My favorite band is Birdtalker, and I got a camping chair for Christmas.";
    }
}
