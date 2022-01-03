package com.xpanxion.java.springboot.da1.demo.controller.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.Member7;
import com.xpanxion.java.springboot.da1.demo.service.student7.MemberService7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MemberController7 {

    @Autowired
    MemberService7 memberService;

    @PostMapping("student7/api/v1/gym/{gymId}/member")
    public Member7 addNewMember(@PathVariable int gymId, @RequestBody Member7 member) {
        return memberService.addMember(gymId, member);
    }
}
