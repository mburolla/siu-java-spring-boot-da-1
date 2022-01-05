package com.xpanxion.java.springboot.da1.demo.model.student4;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="workout4")
public class Workout4 {

    @Id
    @SequenceGenerator(
            name = "workout_id_sequence",
            sequenceName = "workout_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "workout_id_sequence"
    )
    private long workoutId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkIn;
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOut;
    @OneToOne( cascade=CascadeType.ALL, targetEntity = Member4.class)
    @JoinColumn(name = "member_id", referencedColumnName = "memberId")
    private Member4 member;

    public Workout4() {
    }

    public Workout4(Member4 member, Date checkIn){
        this.member= member;
        this.checkIn = checkIn;
    }

    public Workout4(long workoutId, Member4 member, Date checkIn, Date checkOut){
        this.workoutId = workoutId;
        this.member = member;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    //Getters

    public long getWorkoutId() {
        return workoutId;
    }

    public Member4 getMember() {
        return member;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    //Setters

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }

    public void setMember(Member4 member) {
        this.member = member;
    }

    public void setCheckIn(Date timeIn) {
        this.checkIn = timeIn;
    }

    public void setCheckOut(Date timeOut) {
        this.checkOut = timeOut;
    }

    @Override
    public String toString() {
        return "Workout4{" +
                "workoutId=" + workoutId +
                ", member=" + member +
                ", timeIn='" + checkIn + '\'' +
                ", timeOut='" + checkOut + '\'' +
                '}';
    }
}

