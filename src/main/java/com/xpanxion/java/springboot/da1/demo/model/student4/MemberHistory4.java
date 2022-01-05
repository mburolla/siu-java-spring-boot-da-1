package com.xpanxion.java.springboot.da1.demo.model.student4;

import com.xpanxion.java.springboot.da1.demo.model.student1.CheckType;

import java.util.Date;

public class MemberHistory4 {
    private Long memberId;
    private Date timeUtc;
    private Workout4.CheckType checkType;

    public MemberHistory4(Long memberId, Date timeUtc, Workout4.CheckType checkType) {
        this.memberId = memberId;
        this.timeUtc = timeUtc;
        this.checkType = checkType;
    }

    public MemberHistory4() {
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

    public Workout4.CheckType getCheckType() {
        return checkType;
    }

    public void setCheckType(Workout4.CheckType checkType) {
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
