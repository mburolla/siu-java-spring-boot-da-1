package com.xpanxion.java.springboot.da1.demo.view.student5;

public class WorkoutLengthView implements Comparable<WorkoutLengthView> {

    private long lengthInMinutes;
    private long memberId;
    private String date;

    public WorkoutLengthView() {
    }

    public WorkoutLengthView(long lengthInMinutes, long memberId, String date) {
        this.lengthInMinutes = lengthInMinutes;
        this.memberId = memberId;
        this.date = date;
    }

    public long getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(long lengthInMinutes) {
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

    @Override
    public int compareTo(WorkoutLengthView o) {
        if (o.getLengthInMinutes() > this.getLengthInMinutes()) {
            return 1;
        } else if (o.getLengthInMinutes() < this.getLengthInMinutes()) {
            return -1;
        }
        return 0;
    }
}
