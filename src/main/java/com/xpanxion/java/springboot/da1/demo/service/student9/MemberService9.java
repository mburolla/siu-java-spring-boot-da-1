package com.xpanxion.java.springboot.da1.demo.service.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Gym9;
import com.xpanxion.java.springboot.da1.demo.model.student9.Member9;
import com.xpanxion.java.springboot.da1.demo.repository.student9.GymRepository9;
import com.xpanxion.java.springboot.da1.demo.repository.student9.MemberRepository9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class MemberService9 {
    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    private MemberRepository9 memberRepository9;

    //Methods
    public Member9 addMember(Member9 member9){
        return memberRepository9.save(member9);
    }
}
