package com.xpanxion.java.springboot.da1.demo.model.student3;

public class WorkoutHistoryPresentation {

    private int memberId;
    private String time;
    private CheckType3 checkType3;

    public WorkoutHistoryPresentation(){

    }

    public WorkoutHistoryPresentation(int memberId, String time, CheckType3 checkType3) {
        this.memberId = memberId;
        this.time = time;
        this.checkType3 = checkType3;
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

    public CheckType3 getCheckType3() {
        return checkType3;
    }

    public void setCheckType3(CheckType3 checkType3) {
        this.checkType3 = checkType3;
    }
}
