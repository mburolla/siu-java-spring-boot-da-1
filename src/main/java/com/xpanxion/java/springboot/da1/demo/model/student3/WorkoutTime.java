package com.xpanxion.java.springboot.da1.demo.model.student3;

import java.util.Date;

public class WorkoutTime {

    private  int memberId;
    private  String date;
    private long lengthInMinutes;

    public WorkoutTime(){

    }

    public WorkoutTime(long lengthInMinutes, int memberId, String date) {
        this.lengthInMinutes = lengthInMinutes;
        this.memberId = memberId;
        this.date = date;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(long lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }
}
