package com.xpanxion.java.springboot.da1.demo.controller.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.Member5;
import com.xpanxion.java.springboot.da1.demo.service.student5.MemberService5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController5 {

    @Autowired
    private MemberService5 memberService;

    @PostMapping("student5/api/v1/gym/{gymId}/member")
    public Member5 addMember(@PathVariable("gymId") Long gymId, @RequestBody Member5 member5) {
        member5.setGymId(gymId);
        return memberService.addMember(member5);
    }
}
