package com.xpanxion.java.springboot.da1.demo.service.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Member9;
import com.xpanxion.java.springboot.da1.demo.model.student9.MemberHistory9;
import com.xpanxion.java.springboot.da1.demo.repository.student9.MemberHistoryRepository9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

@Service
public class MemberHistoryService9 {
    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    private MemberHistoryRepository9 memberHistoryRepository9;

    @Autowired
    private MemberService9 memberService9;

    //Methods
    public MemberHistory9 addMemberCheckInHistory(int memberId, LocalDateTime time){

        var member9 = memberService9.getFindById(memberId);

        var memberHistory = new MemberHistory9(member9);
        memberHistory.setCheckIn(time);
        return memberHistoryRepository9.save(memberHistory);
    }

    public MemberHistory9 addMemberCheckOutHistory(int memberId, LocalDateTime time){

        var member9 = memberService9.getFindById(memberId);

        var memberHistory = new MemberHistory9(member9);
        memberHistory.setCheckOut(time);
        return memberHistoryRepository9.save(memberHistory);
    }
}
