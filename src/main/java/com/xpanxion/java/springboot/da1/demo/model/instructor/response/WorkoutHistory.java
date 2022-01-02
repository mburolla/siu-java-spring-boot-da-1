package com.xpanxion.java.springboot.da1.demo.model.instructor.response;

import com.xpanxion.java.springboot.da1.demo.model.instructor.CheckType;

import java.util.Date;

public class WorkoutHistory {

    //
    // Data Members
    //

    private Date time;
    private int memberId;
    private CheckType checkType;

    //
    // Constructors
    //

    WorkoutHistory() {
    }

    public WorkoutHistory(Date time, int memberId, CheckType checkType) {
        this.time = time;
        this.memberId = memberId;
        this.checkType = checkType;
    }

    //
    // Accessors
    //

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
