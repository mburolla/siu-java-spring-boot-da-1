package com.xpanxion.java.springboot.da1.demo.service.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Member4;
import com.xpanxion.java.springboot.da1.demo.repository.student4.MemberRepositoryStudent4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class MemberServiceStudent4 {

    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    private MemberRepositoryStudent4 memberRepositoryStudent4;

    public Member4 addMember(Member4 member) {
        return memberRepositoryStudent4.save(member);
    }
}
