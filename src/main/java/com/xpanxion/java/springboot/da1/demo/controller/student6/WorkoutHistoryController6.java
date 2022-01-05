package com.xpanxion.java.springboot.da1.demo.controller.student6;

import com.xpanxion.java.springboot.da1.demo.model.student6.WorkoutHistory6;
import com.xpanxion.java.springboot.da1.demo.service.student6.WorkoutHistoryService6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class WorkoutHistoryController6 {

    @Autowired
    private WorkoutHistoryService6 workoutHistoryService6;

    List<String> whIn;
    List<String> whOut;

    @PostMapping("student6/api/v1/member/{memberId}/local-date-time")
    public WorkoutHistory6 createCheckIn(@RequestParam("localDateTime")@DateTimeFormat(pattern="yyyy-MM-dd H:m:s") Date time) {
        whIn.add(time.toString());
        return (WorkoutHistory6) whIn;

    }

    @PostMapping("student6/api/member/{memberId}/local-date-time")
    public WorkoutHistory6 createCheckOut(@RequestParam("localDateTime")@DateTimeFormat(pattern="yyyy-MM-dd H:m:s") Date time) {
        whOut.add(time.toString());
        return (WorkoutHistory6) whOut;
    }
}
