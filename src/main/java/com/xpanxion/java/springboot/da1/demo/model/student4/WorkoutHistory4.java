package com.xpanxion.java.springboot.da1.demo.model.student4;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="workout_history4")
public class WorkoutHistory4 {
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
    private Long workoutId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeUtc;
    private CheckType checkType;

    @OneToOne( cascade=CascadeType.ALL, targetEntity = Member4.class)
    @JoinColumn(name = "member_id", referencedColumnName = "memberId"
    )
    private Member4 member;

    public WorkoutHistory4() {
    }

    public WorkoutHistory4(Date timeUtc, CheckType checkType, Member4 member) {
        this.timeUtc = timeUtc;
        this.checkType = checkType;
        this.member = member;
    }

    public WorkoutHistory4(Long workoutId, Date timeUtc, CheckType checkType, Member4 member) {
        this.workoutId = workoutId;
        this.timeUtc = timeUtc;
        this.checkType = checkType;
        this.member = member;
    }

    @Override
    public String toString() {
        return "WorkoutHistory5{" +
                "workoutId=" + workoutId +
                ", timeUtc=" + timeUtc +
                ", checkType=" + checkType +
                ", member=" + member +
                '}';
    }

    public Long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Long workoutId) {
        this.workoutId = workoutId;
    }

    public Date getTimeUtc() {
        return timeUtc;
    }

    public void setTimeUtc(Date timeUtc) {
        this.timeUtc = timeUtc;
    }

    public CheckType getCheckType() {
        return checkType;
    }

    public void setCheckType(CheckType checkType) {
        this.checkType = checkType;
    }

    public Member4 getMember() {
        return member;
    }

    public void setMember(Member4 member) {
        this.member = member;
    }

    public enum CheckType {
        CHECK_IN,
        CHECK_OUT
    }
}