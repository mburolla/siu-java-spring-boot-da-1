package com.xpanxion.java.springboot.da1.demo.view.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.WorkoutHistory5;

import java.util.Date;

public class WorkoutHistoryView5 {
    private Long memberId;
    private Date timeUtc;
    private WorkoutHistory5.CheckType checkType;

    public WorkoutHistoryView5() {
    }

    public WorkoutHistoryView5(Long memberId, Date timeUtc, WorkoutHistory5.CheckType checkType) {
        this.memberId = memberId;
        this.timeUtc = timeUtc;
        this.checkType = checkType;
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

    public WorkoutHistory5.CheckType getCheckType() {
        return checkType;
    }

    public void setCheckType(WorkoutHistory5.CheckType checkType) {
        this.checkType = checkType;
    }
}
