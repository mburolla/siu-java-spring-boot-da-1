package com.xpanxion.java.springboot.da1.demo.model.student8;

import com.xpanxion.java.springboot.da1.demo.repository.student8.MemberHistoryRepository8;

import java.util.Date;

public class MemberHistoryReport8 {

    int memberId;
    Date timeUtc;
    CheckInOutType8 checkType;

    public MemberHistoryReport8() {}

    public MemberHistoryReport8(int memberId, Date timeUtc, CheckInOutType8 checkType) {
        this.memberId = memberId;
        this.timeUtc = timeUtc;
        this.checkType = checkType;
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

    public CheckInOutType8 getCheckType() {
        return checkType;
    }

    public void setCheckType(CheckInOutType8 checkType) {
        this.checkType = checkType;
    }
}
