package com.xpanxion.java.springboot.da1.demo.model.instructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name= "WorkoutHistory0")
public class WorkoutHistory0 {

    //
    // Data members
    //

    @Id
    @GeneratedValue
    private int workoutHistoryId;

    private Date time;
    private int memberId;
    private CheckType checkType;

    //
    // Constructors
    //

    public WorkoutHistory0() {

    }

    public WorkoutHistory0(Date time, int memberId, CheckType checkType) {
        this.time = time;
        this.memberId = memberId;
        this.checkType = checkType;
    }

    //
    // Accessors
    //


    public int getWorkoutHistoryId() {
        return workoutHistoryId;
    }

    public void setWorkoutHistoryId(int workoutHistoryId) {
        this.workoutHistoryId = workoutHistoryId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
}
