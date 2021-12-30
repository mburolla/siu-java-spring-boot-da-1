package com.xpanxion.java.springboot.da1.demo.service.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.Member5;
import com.xpanxion.java.springboot.da1.demo.repository.student5.memberRepository5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService5 {

    @Autowired
    private memberRepository5 memberRepository;

    public Member5 addMember(Member5 member) {
        return memberRepository.save(member);
    }
}
