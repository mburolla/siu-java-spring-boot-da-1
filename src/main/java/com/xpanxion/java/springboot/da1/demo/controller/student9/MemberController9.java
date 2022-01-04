package com.xpanxion.java.springboot.da1.demo.controller.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.MemberHistory9;
import com.xpanxion.java.springboot.da1.demo.service.student9.MemberHistoryService9;
import com.xpanxion.java.springboot.da1.demo.service.student9.MemberService9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
public class MemberController9 {
    @Autowired
    private MemberHistoryService9 memberHistoryService9;

    @Autowired
    private MemberService9 memberService9;

    @PostMapping("student9/api/v1/member/{memberId}/checkin")
    public MemberHistory9 addMemberCheckInHistory(@PathVariable int memberId, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd H:m:s") LocalDateTime time ){

        return memberHistoryService9.addMemberCheckInHistory(memberId, time);
    }

    @PostMapping("student9/api/v1/member/{memberId}/checkout")
    public MemberHistory9 addMemberCheckOutHistory(@PathVariable int memberId, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd H:m:s") LocalDateTime time) {

         return memberHistoryService9.addMemberCheckOutHistory(memberId, time);
    }

    @GetMapping("student9/api/v1/member/{memberId}/workout-history")
    public StringBuilder getMemberHistory(@PathVariable int memberId){
        return memberHistoryService9.getMemberWorkOutHistory(memberId);
    }

    @GetMapping("student9/api/v1/member/{memberId}/workout")
    public StringBuilder getWorkoutLength(@PathVariable int memberId, @RequestParam String type){
        return memberHistoryService9.getMemberWorkOutLength(memberId,type);
    }
}
