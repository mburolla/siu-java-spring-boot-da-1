package com.xpanxion.java.springboot.da1.demo.controller.instructor;

import com.xpanxion.java.springboot.da1.demo.model.instructor.WorkoutHistory0;
import com.xpanxion.java.springboot.da1.demo.model.instructor.response.WorkoutTime;
import com.xpanxion.java.springboot.da1.demo.service.instructor.MemberService0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkoutHistory {

    @Autowired
    private MemberService0 memberService0;

    @GetMapping("instructor/api/v1/member/{memberId}/workout-history")
    public List<WorkoutTime> getWorkoutHistory(@PathVariable int memberId) {
        return memberService0.getWorkoutHistory(memberId);
    }
}
