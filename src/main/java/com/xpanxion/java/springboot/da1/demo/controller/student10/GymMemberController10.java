package com.xpanxion.java.springboot.da1.demo.controller.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.GymMember10;
import com.xpanxion.java.springboot.da1.demo.service.student10.GymMemberService10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GymMemberController10 {

    @Autowired
    private GymMemberService10 memberService;

    @PostMapping("student10/api/v1/gym/{gymId}/member")
    public GymMember10 addMember(@PathVariable int gymId, @RequestBody GymMember10 gymMember10) {
        return memberService.addMember(gymId, gymMember10);
    }
}
