package com.xpanxion.java.springboot.da1.demo.controller.student6;

import com.xpanxion.java.springboot.da1.demo.model.student6.Member6;
import com.xpanxion.java.springboot.da1.demo.service.student6.MemberService6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController6 {

    @Autowired
    private MemberService6 memberService6;

    @PostMapping("student6/api/v1/gym/{gymId}/member")
    public Member6 createMember(@RequestBody Member6 member6) {
        return memberService6.postMember(member6);
    }
}
