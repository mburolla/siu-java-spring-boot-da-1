package com.xpanxion.java.springboot.da1.demo.model.instructor.response;

import com.xpanxion.java.springboot.da1.demo.model.instructor.CheckType;

import java.util.Date;
import java.util.Objects;

public class WorkoutTime implements Comparable<WorkoutTime> {

    //
    // Data members
    //

    private int memberId;
    private Date timeUtc;
    private CheckType checkType;

    //
    // Constructors
    //

    public WorkoutTime() {
    }

    public WorkoutTime(int memberId, Date time, CheckType checkType) {
        this.memberId = memberId;
        this.timeUtc = time;
        this.checkType = checkType;
    }

    //
    // Accessors
    //

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getTimeUtc() {
        return timeUtc;
    }

    public void setTimeUtc(Date time) {
        this.timeUtc = time;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkoutTime)) return false;
        WorkoutTime that = (WorkoutTime) o;
        return getMemberId() == that.getMemberId() && getTimeUtc().equals(that.getTimeUtc()) && getCheckType() == that.getCheckType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMemberId(), getTimeUtc(), getCheckType());
    }

    @Override
    public int compareTo(WorkoutTime o) {
        return timeUtc.compareTo(o.getTimeUtc());
    }

    @Override
    public String toString() {
        return "WorkoutTime{" +
                "memberId=" + memberId +
                ", timeUtc=" + timeUtc +
                ", checkType=" + checkType +
                '}';
    }
}
