package com.xpanxion.java.springboot.da1.demo.model.instructor.response;

import com.xpanxion.java.springboot.da1.demo.model.instructor.CheckType;

import java.util.Date;

public class WorkoutTime {

    //
    // Data members
    //

    private int memberId;
    private Date time;
    private CheckType checkType;

    //
    // Constructors
    //

    public WorkoutTime() {
    }

    public WorkoutTime(int memberId, Date time, CheckType checkType) {
        this.memberId = memberId;
        this.time = time;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public CheckType getCheckType() {
        return checkType;
    }

    public void setCheckType(CheckType checkType) {
        this.checkType = checkType;
    }
}
