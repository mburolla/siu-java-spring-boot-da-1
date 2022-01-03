package com.xpanxion.java.springboot.da1.demo.controller.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.WorkoutHistory5;
import com.xpanxion.java.springboot.da1.demo.service.student5.WorkoutHistoryService5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
public class WorkoutHistoryController5 {

    @Autowired
    private WorkoutHistoryService5 workoutHistoryService;

    @PostMapping("student5/api/v1/member/{memberId}/checkin")
    public WorkoutHistory5 checkin(@PathVariable("memberId") Long memberId,
                                   @RequestParam("time") String time) throws ParseException {
        return workoutHistoryService.workoutCheckIn(memberId,
                new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(time));
    }

    @PostMapping("student5/api/v1/member/{memberId}/checkout")
    public WorkoutHistory5 checkout(@PathVariable("memberId") Long memberId,
                                    @RequestParam("time") String time) throws ParseException {
        return workoutHistoryService.workoutCheckOut(memberId,
                new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(time));
    }
}
