package com.xpanxion.java.springboot.da1.demo.model.student10;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="workout_times")
public class WorkoutTimes10 implements Comparable<WorkoutTimes10>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private long lengthInMinutes;
    private int memberId;
    private Date date;

    public WorkoutTimes10() {
    }

    public WorkoutTimes10(long lengthInMinutes, int memberId, Date date) {
        this.lengthInMinutes = lengthInMinutes;
        this.memberId = memberId;
        this.date = date;
    }
    @Override
    public int compareTo(WorkoutTimes10 w) {
        return Long.compare(this.lengthInMinutes, w.lengthInMinutes);
    }

    //Getters
    public Long getId() {
        return id;
    }

    public long getLengthInMinutes() {
        return lengthInMinutes;
    }

    public int getMemberId() {
        return memberId;
    }

    public Date getDate() {
        return date;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setLengthInMinutes(long lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
