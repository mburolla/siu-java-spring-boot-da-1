package com.xpanxion.java.springboot.da1.demo.controller.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.Member2;
import com.xpanxion.java.springboot.da1.demo.service.student2.MemberService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController2 {

    //
    // Data Members
    //

    @Autowired
    private MemberService2 memberService2;

    //
    // Get Methods
    //

    //
    // Post Methods
    //

    @PostMapping("student2/api/v1/{gymId}/member")
    public Member2 addMember(@PathVariable Integer gymId, @RequestBody Member2 member) {
        return memberService2.addMember(gymId, member);
    }
}

