package com.xpanxion.java.springboot.da1.demo.model.student1;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "workoutHistory1")
public class WorkoutHistory1 {

    @Id
    @SequenceGenerator(
            name = "student1_workoutHistorySequence",
            sequenceName = "student1_workoutHistorySequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student1_workoutHistorySequence"
    )
    private int id;
    private int memberId;
    private Date timeUtc;
    private String checkType;

    public WorkoutHistory1() {}

    public WorkoutHistory1(int id, int memberId, Date timeUtc, String checkType) {
        this.id = id;
        this.memberId = memberId;
        this.timeUtc = timeUtc;
        this.checkType = checkType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getTimeUtc() {
        return timeUtc;
    }

    public void setTimeUtc(Date timeUtc) {
        this.timeUtc = timeUtc;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }
}
