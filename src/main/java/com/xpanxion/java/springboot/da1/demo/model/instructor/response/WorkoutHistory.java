package com.xpanxion.java.springboot.da1.demo.model.instructor.response;

import com.xpanxion.java.springboot.da1.demo.model.instructor.CheckType;

import java.util.Date;

public class WorkoutHistory {

    //
    // Data Members
    //

    private Date timeUtc;
    private int memberId;
    private CheckType checkType;

    //
    // Constructors
    //

    WorkoutHistory() {
    }

    public WorkoutHistory(Date time, int memberId, CheckType checkType) {
        this.timeUtc = time;
        this.memberId = memberId;
        this.checkType = checkType;
    }

    //
    // Accessors
    //

    public Date getTimeUtc() {
        return timeUtc;
    }

    public void setTimeUtc(Date time) {
        this.timeUtc = time;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public CheckType getCheckType() {
        return checkType;
    }

    public void setCheckType(CheckType checkType) {
        this.checkType = checkType;
    }
}
