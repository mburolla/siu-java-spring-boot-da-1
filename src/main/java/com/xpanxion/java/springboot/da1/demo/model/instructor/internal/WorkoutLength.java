package com.xpanxion.java.springboot.da1.demo.model.instructor.internal;

import java.util.Objects;

public class WorkoutLength implements Comparable<WorkoutLength> {

    //
    // Data members
    //

    private String Date;
    private long lengthInMinutes;
    private int memberId;

    //
    // Constructors
    //

    public WorkoutLength() {
    }

    //
    // Accessors
    //

    public WorkoutLength(String date, long lengthInMinutes, int memberId) {
        Date = date;
        this.lengthInMinutes = lengthInMinutes;
        this.memberId = memberId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public long getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    //
    // Overrides
    //

    @Override
    public String toString() {
        return "WorkoutLength{" +
                "Date='" + Date + '\'' +
                ", lengthInMinutes=" + lengthInMinutes +
                ", memberId=" + memberId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkoutLength)) return false;
        WorkoutLength that = (WorkoutLength) o;
        return getLengthInMinutes() == that.getLengthInMinutes() && getMemberId() == that.getMemberId() && getDate().equals(that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getLengthInMinutes(), getMemberId());
    }

    @Override
    public int compareTo(WorkoutLength o) {
        if (lengthInMinutes == o.getLengthInMinutes()){
            return 0;
        } else {
            if (lengthInMinutes <= o.getLengthInMinutes())
                return -1;
            else
                return +1;
        }
    }
}
