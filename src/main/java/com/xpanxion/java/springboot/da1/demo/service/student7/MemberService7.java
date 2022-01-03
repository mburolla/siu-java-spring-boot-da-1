package com.xpanxion.java.springboot.da1.demo.service.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.Member7;
import com.xpanxion.java.springboot.da1.demo.repository.student7.GymRepository7;
import com.xpanxion.java.springboot.da1.demo.repository.student7.MemberRepository7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService7 {

    @Autowired
    MemberRepository7 memberRepository7;
    @Autowired
    GymRepository7 gymRepository;

    public Member7 addMember(int gymId, Member7 member) {
        member.setGym(gymRepository.findById(gymId));
        return memberRepository7.save(member);
    }
}
