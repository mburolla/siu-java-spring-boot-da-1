package com.xpanxion.java.springboot.da1.demo.model.student7;

import java.util.Date;

public class WorkOutHistory7 {

    private int memberId;
    private Date timeUtc;
    private String checkType;

    public WorkOutHistory7(int memberId, Date timeUtc, String checkType) {
        this.memberId=memberId;
        this.timeUtc=timeUtc;
        this.checkType=checkType;
    }


    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getTimeUtc() {
        return timeUtc;
    }

    public void setTimeUtc(Date timeUtc) {
        this.timeUtc = timeUtc;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    @Override
    public String toString() {
        return "WorkOutHistory7{" +
                "memberId=" + memberId +
                ", timeUtc=" + timeUtc +
                ", checkType='" + checkType + '\'' +
                '}';
    }
}
