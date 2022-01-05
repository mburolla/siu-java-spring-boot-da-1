package com.xpanxion.java.springboot.da1.demo.controller.student6;

import com.xpanxion.java.springboot.da1.demo.model.student6.WorkoutHistory6;
import com.xpanxion.java.springboot.da1.demo.service.student6.WorkoutHistoryService6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkoutHistoryController6 {

    @Autowired
    private WorkoutHistoryService6 workoutHistoryService6;

    List<WorkoutHistory6> whIn;
    List<WorkoutHistory6> whOut;

    @PostMapping("student6/api/v1/member/{memberId}/checkin?time=2021-12-30 13:48:28")
    public WorkoutHistory6 createCheckIn(@RequestBody WorkoutHistory6 workoutHistory6) {
        whIn.add(workoutHistory6);
        return workoutHistoryService6.save(workoutHistory6);

    }

    @PostMapping("student6/api/member/{memberId}/checkout?time=2021-12-30 13:48:28")
    public WorkoutHistory6 createCheckOut(@RequestBody WorkoutHistory6 workoutHistory6) {
        whOut.add(workoutHistory6);
        return workoutHistoryService6.save(workoutHistory6);
    }
}
