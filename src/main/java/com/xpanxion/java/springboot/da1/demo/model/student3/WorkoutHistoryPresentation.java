package com.xpanxion.java.springboot.da1.demo.model.student3;

import java.util.Date;

public class WorkoutHistoryPresentation {

    private int memberId;
    private Date time;
    private CheckType3 checkType3;

    public WorkoutHistoryPresentation(){

    }

    public WorkoutHistoryPresentation(int memberId, Date time, CheckType3 checkType3) {
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public CheckType3 getCheckType3() {
        return checkType3;
    }

    public void setCheckType3(CheckType3 checkType3) {
        this.checkType3 = checkType3;
    }

    @Override
    public String toString() {
        return "WorkoutHistoryPresentation{" +
                "memberId=" + memberId +
                ", time=" + time +
                ", checkType3=" + checkType3 +
                '}';
    }
}


