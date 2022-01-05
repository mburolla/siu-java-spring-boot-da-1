package com.xpanxion.java.springboot.da1.demo.controller.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Member4;
import com.xpanxion.java.springboot.da1.demo.model.student4.Workout4;
import com.xpanxion.java.springboot.da1.demo.service.student4.MemberServiceStudent4;
import com.xpanxion.java.springboot.da1.demo.service.student4.WorkoutHistoryServiceStudent4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
public class MemberController4 {

    @Autowired
    private MemberServiceStudent4 memberService;
    @Autowired
    private WorkoutHistoryServiceStudent4 workoutHistoryServiceStudent4;

    @PostMapping("student4/api/v1/gym/{gymId}/member")
    public Member4 addMember(@PathVariable("gymId") Long gymId, @RequestBody Member4 member4) {
        member4.setGymId(gymId);
        return memberService.addMember(member4);
    }

    @PostMapping("student4/api/v1/member/{memberId}/checkin")
    public Workout4 checkIn(@PathVariable("memberId") long memberId, @RequestParam("time") String time) throws ParseException {
        return workoutHistoryServiceStudent4.workoutCheckIn(memberId, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(time));
    }

    @PostMapping("student4/api/v1/member/{memberId}/checkout")
    public Workout4 checkOut(@PathVariable long memberId, @RequestParam String time)throws ParseException {
        return workoutHistoryServiceStudent4.workoutCheckOut(memberId, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(time));
    }
}
