package com.xpanxion.java.springboot.da1.demo.model.student4;

public class WorkoutPresentation {

    //
    // Data members
    //

    private int lengthInMinutes;
    private long memberId;
    private String date;

    //
    // Constructors
    //

    public WorkoutPresentation() {
    }

    public WorkoutPresentation(int lengthInMinutes, long memberId, String date) {
        this.lengthInMinutes = lengthInMinutes;
        this.memberId = memberId;
        this.date = date;
    }

    //
    // Accessors
    //

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    //
    // Overrides
    //

    @Override
    public String toString() {
        return "WorkoutPresentation{" +
                "lengthInMinutes=" + lengthInMinutes +
                ", memberId=" + memberId +
                ", date='" + date + '\'' +
                '}';
    }
}
