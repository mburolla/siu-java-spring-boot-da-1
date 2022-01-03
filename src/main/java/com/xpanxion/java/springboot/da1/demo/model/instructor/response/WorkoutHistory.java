package com.xpanxion.java.springboot.da1.demo.model.instructor.response;

import com.xpanxion.java.springboot.da1.demo.model.instructor.CheckType;
import com.xpanxion.java.springboot.da1.demo.model.instructor.WorkoutHistory0;

import java.util.Date;
import java.util.Objects;

public class WorkoutHistory implements Comparable<WorkoutHistory> {

    //
    // Data Members
    //

    private Date timeUtc;
    private int memberId;
    private CheckType checkType;

    //
    // Constructors
    //

    WorkoutHistory() {
    }

    public WorkoutHistory(Date time, int memberId, CheckType checkType) {
        this.timeUtc = time;
        this.memberId = memberId;
        this.checkType = checkType;
    }

    //
    // Accessors
    //

    public Date getTimeUtc() {
        return timeUtc;
    }

    public void setTimeUtc(Date time) {
        this.timeUtc = time;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public CheckType getCheckType() {
        return checkType;
    }

    public void setCheckType(CheckType checkType) {
        this.checkType = checkType;
    }

    //
    // Overrides
    //

    @Override
    public int compareTo(WorkoutHistory o) {
        return timeUtc.compareTo(o.getTimeUtc());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkoutHistory)) return false;
        WorkoutHistory that = (WorkoutHistory) o;
        return getMemberId() == that.getMemberId() && getTimeUtc().equals(that.getTimeUtc()) && getCheckType() == that.getCheckType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTimeUtc(), getMemberId(), getCheckType());
    }
}
