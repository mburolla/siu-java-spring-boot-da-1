package com.xpanxion.java.springboot.da1.demo.controller.instructor;

import com.xpanxion.java.springboot.da1.demo.model.instructor.CheckType;
import com.xpanxion.java.springboot.da1.demo.model.instructor.Member0;
import com.xpanxion.java.springboot.da1.demo.model.instructor.response.WorkoutHistory;
import com.xpanxion.java.springboot.da1.demo.service.instructor.MemberService0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@RestController
public class MemberController0 {

    @Autowired
    private MemberService0 memberService0;

    @PostMapping("instructor/api/v1/gym/{gymId}/member")
    public Member0 addGym(@RequestBody Member0 member, @PathVariable int gymId) {
        member.setMemberId(memberService0.addMemberToGymId(member, gymId));
        return member;
    }

    @PostMapping("instructor/api/v1/member/{memberId}/checkin")
    public WorkoutHistory addWorkoutHistoryCheckIn(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd H:m:s") Date time, @PathVariable int memberId) {
        memberService0.checkMember(CheckType.CHECK_IN,memberId, time);
        return new WorkoutHistory(time, memberId, CheckType.CHECK_IN);
    }

    @PostMapping("instructor/api/v1/member/{memberId}/checkout")
    public WorkoutHistory addWorkoutHistoryCheckout(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd H:m:s") Date time, @PathVariable int memberId) {
        memberService0.checkMember(CheckType.CHECK_OUT,memberId, time);
        return new WorkoutHistory(time, memberId, CheckType.CHECK_OUT);
    }
}
