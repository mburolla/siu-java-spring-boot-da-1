package com.xpanxion.java.springboot.da1.demo.model.student4;

import javax.persistence.*;

@Entity
@Table(name="workout4")
public class Workout4 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int workoutId;

    @OneToOne( cascade=CascadeType.ALL, targetEntity = Member4.class)
    @JoinColumn(name = "member_id", referencedColumnName = "memberId")
    private Member4 member;

    private String timeIn;
    private String timeOut;

    public Workout4() {
    }

    public Workout4(Member4 member, String timeIn){
        this.member= member;
        this.timeIn = timeIn;
        this.timeOut = null;
    }

    public Workout4(int workoutId, Member4 member, String timeIn, String timeOut){
        this.workoutId = workoutId;
        this.member = member;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    //Getters

    public int getWorkoutId() {
        return workoutId;
    }

    public Member4 getMember() {
        return member;
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

    public void setMember(Member4 member) {
        this.member = member;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    @Override
    public String toString() {
        return "Workout4{" +
                "workoutId=" + workoutId +
                ", member=" + member +
                ", timeIn='" + timeIn + '\'' +
                ", timeOut='" + timeOut + '\'' +
                '}';
    }
}

