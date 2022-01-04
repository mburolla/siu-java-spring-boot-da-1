package com.xpanxion.java.springboot.da1.demo.model.student10;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="workout_history")
public class Workout10 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int workoutId;
    private int memberId;
    private Date timeStamp;
    private String checkType;

    public Workout10() {
    }

    public Workout10(int memberId, Date timeStamp, String checkType){
        this.memberId = memberId;
        this.timeStamp = timeStamp;
        this.checkType = checkType;
    }

    //Getters

    public int getWorkoutId() {
        return workoutId;
    }

    public int getMemberId() {
        return memberId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getCheckType() {
        return checkType;
    }

    //Setters

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setTimeStamp(String timeIn) {
        this.timeStamp = timeStamp;
    }

    public void setCheckType(String timeOut) {
        this.checkType = checkType;
    }
}
