package com.xpanxion.java.springboot.da1.demo.model.student3;

public class WorkoutTime {

    private  int memberId;
    private String time;
    private String date;

    public WorkoutTime(){

    }

    public WorkoutTime(int memberId, String time) {
        this.memberId = memberId;
        this.time = time;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
