package com.xpanxion.java.springboot.da1.demo.service.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Member9;
import com.xpanxion.java.springboot.da1.demo.model.student9.MemberHistory9;
import com.xpanxion.java.springboot.da1.demo.repository.student9.MemberHistoryRepository9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class MemberHistoryService9 {
    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    private MemberHistoryRepository9 memberHistoryRepository9;

    //Methods
    public MemberHistory9 addMemberHistory(MemberHistory9 memberHistory9){
        return memberHistoryRepository9.save(memberHistory9);
    }
}
