package com.xpanxion.java.springboot.da1.demo.controller.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.History2;
import com.xpanxion.java.springboot.da1.demo.service.student2.HistoryService2;
import com.xpanxion.java.springboot.da1.demo.service.student2.MemberIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;

@RestController
public class HistoryController2 {

    @Autowired
    private HistoryService2 historyService2;

    @PostMapping("student2/api/v1/member/{memberId}/checkin{time}")
    public History2 addHistoryIn(@PathVariable int memberId, @RequestParam Timestamp time) throws ResponseStatusException {
        try {
            return historyService2.addHistoryIn(memberId, time);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "member id not found");
        }
    }

    @PostMapping("student2/api/v1/member/{memberId}/checkout{time}")
    public History2 addHistoryOut(@PathVariable int memberId, @RequestParam Timestamp time) {
        try {
            return historyService2.addHistoryOut(memberId, time);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "member id not found");
        }
    }
}
