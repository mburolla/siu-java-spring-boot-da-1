package com.xpanxion.java.springboot.da1.demo.model.student2;

import java.util.Date;

public class WorkoutLength2 {

    //
    // Data members
    //

    private int lengthInMinutes;
    private int memberId;
    private Date date;

    //
    // Constructors
    //

    public WorkoutLength2() {
        this.lengthInMinutes = -1;
        this.memberId = -1;
        this.date = new Date(0);
    }

    public WorkoutLength2(int lengthInMinutes, int memberId, Date date) {
        this.lengthInMinutes = lengthInMinutes;
        this.memberId = memberId;
        this.date = date;
    }

    //
    // Getters
    //


    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public int getMemberId() {
        return memberId;
    }

    public Date getDate() {
        return date;
    }

    //
    // Setters
    //


    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

