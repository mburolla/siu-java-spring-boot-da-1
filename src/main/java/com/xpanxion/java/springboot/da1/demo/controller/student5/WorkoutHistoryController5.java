package com.xpanxion.java.springboot.da1.demo.controller.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.WorkoutHistory5;
import com.xpanxion.java.springboot.da1.demo.service.student5.WorkoutHistoryService5;
import com.xpanxion.java.springboot.da1.demo.view.student5.WorkoutHistoryView5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class  WorkoutHistoryController5 {

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

    @GetMapping("student5/api/v1/member/{memberId}/workout-history")
    public List<WorkoutHistoryView5> workoutHistory(@PathVariable("memberId") Long memberId) {
        return workoutHistoryService.findAllByMemberMemberId(memberId);
    }
}
