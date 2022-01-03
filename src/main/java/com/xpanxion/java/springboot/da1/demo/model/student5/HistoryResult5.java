package com.xpanxion.java.springboot.da1.demo.model.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.WorkoutHistory5.CheckType;

import java.util.Date;

public class HistoryResult5 {

    private Long memberId;
    private Date timeUtc;
    private CheckType checkType;

    public HistoryResult5(Long memberId, Date timeUtc, CheckType checkType) {
        this.memberId = memberId;
        this.timeUtc = timeUtc;
        this.checkType = checkType;
    }

    public HistoryResult5() {
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Date getTimeUtc() {
        return timeUtc;
    }

    public void setTimeUtc(Date timeUtc) {
        this.timeUtc = timeUtc;
    }

    public CheckType getCheckType() {
        return checkType;
    }

    public void setCheckType(CheckType checkType) {
        this.checkType = checkType;
    }

    @Override
    public String toString() {
        return "HistoryResult5{" +
                "memberId=" + memberId +
                ", timeUtc=" + timeUtc +
                ", checkType=" + checkType +
                '}';
    }
}
