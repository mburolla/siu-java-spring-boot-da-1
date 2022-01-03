package com.xpanxion.java.springboot.da1.demo.controller.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.MemberCheckIn7;
import com.xpanxion.java.springboot.da1.demo.service.student7.MemberCheckInService7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MemberCheckInController7 {

    @Autowired
    MemberCheckInService7 memberCheckInService;

    @PostMapping("student7/api/v1/member/{memberId}/checkin") //?time=2021-12-30 13:48:28")
    public MemberCheckIn7 memberCheckIn(@PathVariable int memberId, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd H:m:s") Date time) {
    return memberCheckInService.checkIn(memberId, time);
    }

    @PostMapping("student7/api/v1/member/{memberId}/checkout") //?time=2021-12-30 13:48:28")
    public MemberCheckIn7 memberCheckOut(@PathVariable int memberId, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd H:m:s") Date time) {
        return memberCheckInService.checkout(memberId, time);
    }
}
