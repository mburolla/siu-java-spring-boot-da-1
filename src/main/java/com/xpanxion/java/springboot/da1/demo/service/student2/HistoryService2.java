package com.xpanxion.java.springboot.da1.demo.service.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.Checkin2;
import com.xpanxion.java.springboot.da1.demo.model.student2.Checkout2;
import com.xpanxion.java.springboot.da1.demo.repository.student2.CheckinRepository2;
import com.xpanxion.java.springboot.da1.demo.repository.student2.CheckoutRepository2;
import com.xpanxion.java.springboot.da1.demo.repository.student2.MemberRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;

@Service
public class HistoryService2 {

    Checkin2 checkin = new Checkin2();
    Checkout2 checkout = new Checkout2();

    @Autowired
    private MemberRepository2 memberRepository2;

    @Autowired
    private CheckinRepository2 checkinRepository2;

    @Autowired
    private CheckoutRepository2 checkoutRepository2;

    public Checkin2 addHistoryIn(int memberId, Timestamp time) {
        checkin.setCheckin(time);

        try {
            checkin.setMember2(memberRepository2.findById(memberId));
            if (checkin.getMember2() == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "member id not found");
            }
        } catch (Exception e) {
            throw e;
        }
        return checkinRepository2.save(checkin);
    }

    public Checkout2 addHistoryOut(int memberId, Timestamp time) {
        checkout.setCheckout(time);
        try {
            checkout.setMember2(memberRepository2.findById(memberId));
            if (checkout.getMember2() == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "member id not found");
            }
        } catch (Exception e) {
            throw e;
        }
        return checkoutRepository2.save(checkout);
    }
}
