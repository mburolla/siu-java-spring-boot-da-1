package com.xpanxion.java.springboot.da1.demo.model.instructor.response;

import com.xpanxion.java.springboot.da1.demo.model.instructor.CheckType;

import java.util.Date;

public class WorkoutTime {

    //
    // Data members
    //

    private int memberId;
    private Date timeUtc;
    private CheckType checkType;

    //
    // Constructors
    //

    public WorkoutTime() {
    }

    public WorkoutTime(int memberId, Date time, CheckType checkType) {
        this.memberId = memberId;
        this.timeUtc = time;
        this.checkType = checkType;
    }

    //
    // Accessors
    //

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getTimeUtc() {
        return timeUtc;
    }

    public void setTimeUtc(Date time) {
        this.timeUtc = time;
    }

    public CheckType getCheckType() {
        return checkType;
    }

    public void setCheckType(CheckType checkType) {
        this.checkType = checkType;
    }
}
