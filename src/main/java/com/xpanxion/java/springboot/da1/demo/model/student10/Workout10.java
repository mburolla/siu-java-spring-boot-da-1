package com.xpanxion.java.springboot.da1.demo.model.student10;

import javax.persistence.*;

@Entity
@Table(name="workout_history")
public class Workout10 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int workoutId;
    private int memberId;
    private String timeIn;
    private String timeOut;

    public Workout10() {
    }

    public Workout10(int memberId, String timeIn){
        this.memberId = memberId;
        this.timeIn = timeIn;
        this.timeOut = null;
    }

    public Workout10(int workoutId, int memberId, String timeIn, String timeOut){
        this.workoutId = workoutId;
        this.memberId = memberId;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    //Getters

    public int getWorkoutId() {
        return workoutId;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    //Setters

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }
}
