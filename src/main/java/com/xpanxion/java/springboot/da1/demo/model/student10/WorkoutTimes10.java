package com.xpanxion.java.springboot.da1.demo.model.student10;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="workout_times")
public class WorkoutTimes10 {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private long lengthInMinutes;
    private int memberId;
    private String date;

    public WorkoutTimes10() {
    }

    public WorkoutTimes10(long lengthInMinutes, int memberId, String date) {
        this.lengthInMinutes = lengthInMinutes;
        this.memberId = memberId;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
