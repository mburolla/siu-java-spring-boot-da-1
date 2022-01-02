package com.xpanxion.java.springboot.da1.demo.controller.instructor;

import com.xpanxion.java.springboot.da1.demo.model.instructor.Member0;
import com.xpanxion.java.springboot.da1.demo.service.instructor.MemberService0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController0 {

    @Autowired
    private MemberService0 memberService0;

    @PostMapping("instructor/api/v1/gym/{gymId}/member")
    public Member0 addGym(@RequestBody Member0 member, @PathVariable int gymId) {
        member.setMemberId(memberService0.addMemberToGymId(member, gymId));
        return member;
    }
}
