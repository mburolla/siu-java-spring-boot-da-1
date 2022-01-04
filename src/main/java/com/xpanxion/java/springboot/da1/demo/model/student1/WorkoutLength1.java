package com.xpanxion.java.springboot.da1.demo.model.student1;

import javax.persistence.*;
import java.util.Date;

public class WorkoutLength1 implements Comparable<WorkoutLength1> {

    private int lengthInMinutes;
    private int memberId;
    private String date;

    public WorkoutLength1(){}

    public WorkoutLength1(int lengthInMinutes, int memberId, String date) {
        this.lengthInMinutes = lengthInMinutes;
        this.memberId = memberId;
        this.date = date;
    }

    public int getLengthInMinutes() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(WorkoutLength1 o) {
        if (o.getLengthInMinutes() > this.getLengthInMinutes()) {
            return 1;
        } else if (o.getLengthInMinutes() < this.getLengthInMinutes()) {
            return -1;
        }
        return 0;
    }

}
