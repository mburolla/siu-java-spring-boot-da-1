package com.xpanxion.java.springboot.da1.demo.controller.student4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController4 {

    @GetMapping("student4/api/v1/message")
    public String getMessage() {return "My name is Elsa Michael(no middle initial).My favorite color is blue.My favourite band is Boney M.I got two pair of glasses for Christmas";
    }
}