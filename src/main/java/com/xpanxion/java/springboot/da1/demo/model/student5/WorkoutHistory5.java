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
    private long workoutId;
    private long memberId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkIn;
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOut;

    public WorkoutHistory5() {
    }

    public WorkoutHistory5(long memberId, Date checkIn) {
        this.memberId = memberId;
        this.checkIn = checkIn;
        this.checkOut = null;
    }

    public WorkoutHistory5(long workoutId, long memberId, Date checkIn, Date checkOut) {
        this.workoutId = workoutId;
        this.memberId = memberId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "WorkoutHistory5{" +
                "workoutId=" + workoutId +
                ", memberId=" + memberId +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }

    public long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
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
}
