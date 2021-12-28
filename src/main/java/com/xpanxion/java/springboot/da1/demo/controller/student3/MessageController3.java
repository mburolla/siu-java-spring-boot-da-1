package com.xpanxion.java.springboot.da1.demo.controller.student3;

import com.xpanxion.java.springboot.da1.demo.service.student3.DataService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController3 {

    @Autowired
    private DataService3 dataService3;

    @GetMapping("student3/api/v1/message")
    public String getMessage() {
        return dataService3.getMessage();
    }
}
