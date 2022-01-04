package com.xpanxion.java.springboot.da1.demo.controller.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Member8;
import com.xpanxion.java.springboot.da1.demo.model.student8.Timestamp8;
import com.xpanxion.java.springboot.da1.demo.service.student8.GymService8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MemberController8 {

    @Autowired
    GymService8 gymService8;

    @PostMapping("student8/api/v1/gym/{gymId}/member")
    public void addMember(@RequestBody Member8 member, @PathVariable("gymId") Integer gymId) {
        gymService8.addMember(member, gymId);
    }

    @PostMapping("student8/api/v1/member/{memberId}/checkin") //?time=2021-12-20 13:48:28
    public Timestamp8 addTimeIn(@PathVariable("memberId") Integer memberId, @RequestParam String time) {
        return gymService8.memberCheckIn(memberId, time);
    }

    @PostMapping("student8/api/v1/member/{memberId}/checkout") //?time=2021-12-20 13:48:28
    public Timestamp8 addTimeOut(@PathVariable("memberId") Integer memberId, @RequestParam String time) {
        return gymService8.memberCheckOut(memberId, time);
    }
}
