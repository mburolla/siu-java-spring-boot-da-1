package com.xpanxion.java.springboot.da1.demo.controller.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Member4;
import com.xpanxion.java.springboot.da1.demo.model.student4.Workout4;
import com.xpanxion.java.springboot.da1.demo.model.student4.WorkoutHistory4;
import com.xpanxion.java.springboot.da1.demo.service.student4.MemberServiceStudent4;
import com.xpanxion.java.springboot.da1.demo.service.student4.WorkoutHistoryServiceStudent4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController4 {

    @Autowired
    private MemberServiceStudent4 memberService;

    @PostMapping("student4/api/v1/gym/{gymId}/member")
    public Member4 addMember(@PathVariable("gymId") Long gymId, @RequestBody Member4 member4) {
        member4.setGymId(gymId);
        return memberService.addMember(member4);
    }

    @PostMapping("student4/api/v1/member/{memberId}/checkin")
    public Workout4 checkIn(@PathVariable int memberId, @RequestParam String time) {
        return memberService.checkIn(memberId, time);
    }

    @PostMapping("student4/api/v1/member/{memberId}/checkout")
    public Workout4 checkOut(@PathVariable int memberId, @RequestParam String time) {
        return memberService.checkOut(memberId, time);
    }

    @Autowired
    private WorkoutHistoryServiceStudent4 workoutHistoryServiceStudent4;

    @GetMapping("student4/api/v1/member/{memberId}/workout-history")
    public List<WorkoutHistory4> workoutHistory(@PathVariable("memberId") Long memberId) {
        return workoutHistoryServiceStudent4.findAllByMemberMemberId(memberId);
    }
}