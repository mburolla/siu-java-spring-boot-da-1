package com.xpanxion.java.springboot.da1.demo.service.student6;

import com.xpanxion.java.springboot.da1.demo.model.student6.Member6;
import com.xpanxion.java.springboot.da1.demo.repository.student6.MemberRepository6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService6 {

    @Autowired
    private MemberRepository6 memberRepository6;
    public Member6 postMember (Member6 member6) {
        return memberRepository6.saveAndFlush(member6);
    }
}
