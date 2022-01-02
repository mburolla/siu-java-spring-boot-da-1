package com.xpanxion.java.springboot.da1.demo.service.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.Member2;
import com.xpanxion.java.springboot.da1.demo.repository.student2.GymRepository2;
import com.xpanxion.java.springboot.da1.demo.repository.student2.MemberRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberService2 {

    @Autowired
    private GymRepository2 gymRepository2;

    @Autowired
    private MemberRepository2 memberRepository2;

    public Member2 addMember(int gymId, Member2 member) {
        member.setGym2(gymRepository2.findById(gymId));
        return memberRepository2.save(member);
    }
}