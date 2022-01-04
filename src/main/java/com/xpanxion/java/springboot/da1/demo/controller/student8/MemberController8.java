package com.xpanxion.java.springboot.da1.demo.controller.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Member8;
import com.xpanxion.java.springboot.da1.demo.model.student8.Timestamp8;
import com.xpanxion.java.springboot.da1.demo.service.student8.GymService8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@RestController
public class MemberController8 {

    @Autowired
    GymService8 gymService8;

//    @GetMapping("student8/api/v1/member/{memberId}/workout-history")
//    public List<WorkoutHistory8> getWorkoutHistory(@PathVariable("memberId") Integer memberId) {
//        List<WorkoutHistory8> workingHistoryList = gymService8.getMemberWorkoutHistory(memberId);
//        return workingHistoryList;
//    }

    @PostMapping("student8/api/v1/gym/{gymId}/member")
    public void addMember(@RequestBody Member8 member, @PathVariable("gymId") Integer gymId) {
        gymService8.addMember(member, gymId);
    }

    @PostMapping("student8/api/v1/member/{memberId}/checkin") //?time=2021-12-20 13:48:28
    public Timestamp8 addTimeIn(@PathVariable("memberId") Integer memberId,
                                @RequestParam("time") Timestamp time) {
        return gymService8.memberCheckIn(memberId, time);
    }

    @PostMapping("student8/api/v1/member/{memberId}/checkout") //?time=2021-12-20 13:48:28
    public Timestamp8 addTimeOut(@PathVariable("memberId") Integer memberId,
                                 @RequestParam("time") Timestamp time) {
        return gymService8.memberCheckOut(memberId, time);
    }
//    @PostMapping("student8/api/v1/member/{memberId}/checkin") //?time=2021-12-20 13:48:28
//    public Timestamp8 addTimeIn(@PathVariable("memberId") Integer memberId,
//                                @RequestParam("time")
//                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime time) {
//        return gymService8.memberCheckIn(memberId, time);
//    }
//
//    @PostMapping("student8/api/v1/member/{memberId}/checkout") //?time=2021-12-20 13:48:28
//    public Timestamp8 addTimeOut(@PathVariable("memberId") Integer memberId,
//                                 @RequestParam("time")
//                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime time) {
//        return gymService8.memberCheckOut(memberId, time);
//    }
}
