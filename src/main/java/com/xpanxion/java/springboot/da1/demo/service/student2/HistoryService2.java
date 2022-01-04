package com.xpanxion.java.springboot.da1.demo.service.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.*;
import com.xpanxion.java.springboot.da1.demo.repository.student2.CheckinRepository2;
import com.xpanxion.java.springboot.da1.demo.repository.student2.CheckoutRepository2;
import com.xpanxion.java.springboot.da1.demo.repository.student2.MemberRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class HistoryService2 {

    int MILLISECONDS_TO_MINUTES = 60*1000;

    List<WorkoutHistory2> workoutHistory = new ArrayList<WorkoutHistory2>();

    Checkin2 checkin = new Checkin2();
    Checkout2 checkout = new Checkout2();

    @Autowired
    private MemberRepository2 memberRepository2;

    @Autowired
    private CheckinRepository2 checkinRepository2;

    @Autowired
    private CheckoutRepository2 checkoutRepository2;

    public List<WorkoutHistory2> getHistory(int memberId) {

        List<WorkoutHistory2> workoutHistory = new ArrayList<WorkoutHistory2>();
        List<Checkin2> checkinHistory = checkinRepository2.findBymember2Id(memberId);
        List<Checkout2> checkoutHistory = checkoutRepository2.findBymember2Id(memberId);

        if(!memberRepository2.existsById(memberId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "member id not found");
        }

        for (Checkin2 n : checkinHistory) {
            workoutHistory.add(new WorkoutHistory2(memberId, n.getCheckin(), "CHECK_IN"));
        }
        for (Checkout2 n : checkoutHistory) {
            workoutHistory.add(new WorkoutHistory2(memberId, n.getCheckout(), "CHECK_OUT"));
        }

        return workoutHistory;

    }

    public WorkoutLength2 getWorkoutLength(int memberId, String type) {

        List<WorkoutHistory2> workoutHistory = new ArrayList<WorkoutHistory2>();
        List<WorkoutLength2> workoutLength = new ArrayList<WorkoutLength2>();
        List<Checkin2> checkinHistory = checkinRepository2.findBymember2Id(memberId);
        List<Checkout2> checkoutHistory = checkoutRepository2.findBymember2Id(memberId);

        if(!memberRepository2.existsById(memberId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "member id not found");
        }

        for (int i = 0; i < Math.min(checkinHistory.size(),checkoutHistory.size()); i++) {
            long timestampInMilliseconds = checkoutHistory.get(i).getCheckout().getTime() - checkinHistory.get(i).getCheckin().getTime();
            workoutLength.add(new WorkoutLength2(
                    (int) timestampInMilliseconds/MILLISECONDS_TO_MINUTES,
                    memberId,
                    new Date(checkinHistory.get(i).getCheckin().getTime())));
        }

        if(workoutLength.size() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "require more checkin/checkout data");
        }

        Collections.sort(workoutLength, new SortByLength());

        if(type.equals("min")) {
            return workoutLength.get(0);
        }
        else if(type.equals("max")) {
            return workoutLength.get(workoutLength.size()-1);
        }
        else {
            return new WorkoutLength2();
        }
    }

    public Checkin2 addHistoryIn(int memberId, Timestamp time) {
        checkin.setCheckin(time);
        checkin.setMember2(memberRepository2.findById(memberId));
        if (checkin.getMember2() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "member id not found");
        }
        return checkinRepository2.save(checkin);
    }

    public Checkout2 addHistoryOut(int memberId, Timestamp time) {

        checkout.setCheckout(time);
        checkout.setMember2(memberRepository2.findById(memberId));
        if (checkout.getMember2() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "member id not found");
        }
        return checkoutRepository2.save(checkout);
    }
}
