package com.xpanxion.java.springboot.da1.demo.service.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.GymMember10;
import com.xpanxion.java.springboot.da1.demo.repository.student10.GymMemberRepository10;
import com.xpanxion.java.springboot.da1.demo.repository.student10.GymRepository10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymMemberService10 {

    @Autowired
    private GymRepository10 gymRepository;
    @Autowired
    private GymMemberRepository10 memberRepository;

    public GymMember10 addMember(int gymId, GymMember10 member){
        member.setGym(gymRepository.findById(gymId));
        return memberRepository.save(member);
    }
}
