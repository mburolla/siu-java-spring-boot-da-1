package com.xpanxion.java.springboot.da1.demo.service.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.History2;
import com.xpanxion.java.springboot.da1.demo.repository.student2.HistoryRepository2;
import com.xpanxion.java.springboot.da1.demo.repository.student2.MemberRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class HistoryService2 {

    History2 history = new History2();

    @Autowired
    private MemberRepository2 memberRepository2;

    @Autowired
    private HistoryRepository2 historyRepository2;

    public History2 addHistoryIn(int memberId, Timestamp time) {
        history.setCheckin(time);
        history.setMember2(memberRepository2.findById(memberId));
        return historyRepository2.save(history);
    }

    public History2 addHistoryOut(int memberId, Timestamp time) {
        history.setCheckout(time);
        history.setMember2(memberRepository2.findById(memberId));
        return historyRepository2.save(history);
    }
}
