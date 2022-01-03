package com.xpanxion.java.springboot.da1.demo.controller.student3;


import com.xpanxion.java.springboot.da1.demo.model.student3.Member3;
import com.xpanxion.java.springboot.da1.demo.service.student3.GymService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController3 {

    @Autowired
    private GymService3 gymService3;

    @PostMapping("student3/api/v1/gym/{gymId}/member")
    public Member3 addMember(@RequestBody Member3 member3, @PathVariable("gymId") int gymId){
        return gymService3.addMember(member3, gymId);
    }


}
