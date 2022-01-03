package com.xpanxion.java.springboot.da1.demo.model.student5;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="workout_history5")
public class WorkoutHistory5 {

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
    private Date checkIn;
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOut;

    @OneToOne
    @JoinColumn(
            name = "member_id",
            referencedColumnName = "memberId"
    )
    private Member5 member;

    public WorkoutHistory5() {
    }

    public WorkoutHistory5(Member5 member, Date checkIn) {
        this.checkIn = checkIn;
        this.member = member;
    }

    public WorkoutHistory5(Long workoutId, Date checkIn, Date checkOut, Member5 member) {
        this.workoutId = workoutId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.member = member;
    }

    public Long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Long workoutId) {
        this.workoutId = workoutId;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Member5 getMember() {
        return member;
    }

    public void setMember(Member5 member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "WorkoutHistory5{" +
                "workoutId=" + workoutId +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", member=" + member +
                '}';
    }
}
