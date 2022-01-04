package com.xpanxion.java.springboot.da1.demo.controller.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Member4;
import com.xpanxion.java.springboot.da1.demo.service.student4.MemberServiceStudent4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController4 {

    @Autowired
    private MemberServiceStudent4 memberService;

    @PostMapping("student4/api/v1/gym/{gymId}/member")
    public Member4 addMember(@PathVariable("gymId") Long gymId, @RequestBody Member4 member4) {
        member4.setGymId(gymId);
        return memberService.addMember(member4);
    }
}