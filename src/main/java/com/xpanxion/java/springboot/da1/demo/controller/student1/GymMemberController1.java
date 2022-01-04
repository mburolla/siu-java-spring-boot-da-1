package com.xpanxion.java.springboot.da1.demo.controller.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.WorkoutHistory1;
import com.xpanxion.java.springboot.da1.demo.model.student1.WorkoutLength1;
import com.xpanxion.java.springboot.da1.demo.service.student1.GymService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RequestMapping("student1/api/v1/member/{memberId}")
@RestController
public class GymMemberController1 {

    @Autowired
    GymService1 gymService1;

    @GetMapping(path = "workout-history")
    List<WorkoutHistory1> getMemberWorkoutHistory(@PathVariable("memberId") int memberId) {

        return gymService1.getWorkoutHistory(memberId);

    }

    @GetMapping(path = "workout")
    WorkoutLength1 getWorkoutLengthForMember(@PathVariable("memberId") int memberId, @RequestParam("type") String minOrMax) {

        return gymService1.getWorkoutLength(memberId, minOrMax);

    }

    @PostMapping(path = "checkin&time={checkInTime}")
    String checkInGym(@PathVariable("memberId") int memberId,
                                       @PathVariable("checkInTime") String checkIn) throws ParseException {

        return gymService1.checkIn(memberId, checkIn);

    }

    @PostMapping(path = "checkout&time={checkOutTime}")
    String checkOutGym(@PathVariable("memberId") int memberId,
                                        @PathVariable("checkOutTime") String checkOut) throws ParseException {

        return gymService1.checkOut(memberId, checkOut);

    }


}
