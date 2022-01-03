package com.xpanxion.java.springboot.da1.demo.model.student2;

import java.sql.Timestamp;

public class WorkoutHistory2 {

    //
    // Data members
    //

    private int memberId;
    private Timestamp timeUtc;
    private String checkType;

    //
    // Constructors
    //

    public WorkoutHistory2() {
        this.memberId = -1;
        this.timeUtc = new Timestamp(0, 0, 0, 0, 0, 0, 0);
        this.checkType = "";
    }

    public WorkoutHistory2(int memberId, Timestamp timeUtc, String checkType) {
        this.memberId = memberId;
        this.timeUtc = timeUtc;
        this.checkType = checkType;
    }

    //
    // Getters
    //

    public int getMemberId() {
        return memberId;
    }

    public Timestamp getTimeUtc() {
        return timeUtc;
    }

    public String getCheckType() {
        return checkType;
    }

    //
    // Setters
    //

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setTimeUtc(Timestamp timeUtc) {
        this.timeUtc = timeUtc;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }
}
