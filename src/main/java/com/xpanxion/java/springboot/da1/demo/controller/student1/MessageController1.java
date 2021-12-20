package com.xpanxion.java.springboot.da1.demo.controller.student1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController1 {

    @GetMapping("student1/api/v1/message")
    public String getMessage() {
        int a = 1;
        return "My name is Kris D Norful. My favorite color is RED. My favorite band is Outkast.";
    }
}
