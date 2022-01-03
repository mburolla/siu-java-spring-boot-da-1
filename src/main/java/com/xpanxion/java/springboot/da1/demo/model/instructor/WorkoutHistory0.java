package com.xpanxion.java.springboot.da1.demo.model.instructor;

import com.xpanxion.java.springboot.da1.demo.model.instructor.response.WorkoutHistory;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="WorkoutHistory0")
public class WorkoutHistory0 implements Comparable<WorkoutHistory0> {

    //
    // Data members
    //

    @Id
    @GeneratedValue
    private int workoutHistoryId;

    @OneToOne(targetEntity = Member0.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", referencedColumnName = "memberId")
    private Member0 member0;

    private Date time;
    private CheckType checkType;

    //
    // Constructors
    //

    public WorkoutHistory0() { }

    public WorkoutHistory0(Member0 member, Date time, CheckType checkType) {
        this.member0 = member;
        this.time = time;
        this.checkType = checkType;
    }

    //
    // Accessors
    //

    public Member0 getMember0() {
        return member0;
    }

    public void setMember0(Member0 member0) {
        this.member0 = member0;
    }

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
    public int compareTo(WorkoutHistory0 o) {
        return time.compareTo(o.getTime());
    }
}
