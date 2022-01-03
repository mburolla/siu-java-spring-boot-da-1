package com.xpanxion.java.springboot.da1.demo.controller.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.Checkin2;
import com.xpanxion.java.springboot.da1.demo.model.student2.Checkout2;
import com.xpanxion.java.springboot.da1.demo.service.student2.HistoryService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;

@RestController
public class HistoryController2 {

    @Autowired
    private HistoryService2 historyService2;

    @PostMapping("student2/api/v1/member/{memberId}/checkin{time}")
    public Checkin2 addHistoryIn(@PathVariable int memberId, @RequestParam Timestamp time) throws ResponseStatusException {
        return historyService2.addHistoryIn(memberId, time);
    }

    @PostMapping("student2/api/v1/member/{memberId}/checkout{time}")
    public Checkout2 addHistoryOut(@PathVariable int memberId, @RequestParam Timestamp time) {
        try {
            return historyService2.addHistoryOut(memberId, time);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "member id not found");
        }
    }
}
