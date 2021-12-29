package com.xpanxion.java.springboot.da1.demo.controller.student6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private DataAccess dataAccess;

    @GetMapping("student6/api/v1/book/{id}")
    public String bookList() { return dataAccess.getBook(); }

}
