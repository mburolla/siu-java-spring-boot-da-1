package com.xpanxion.java.springboot.da1.demo.model.student9;

import java.time.Duration;
import java.time.LocalDate;

public class WorkoutLength9 {
    private Long lengthInMinutes;
    private int memberId;
    private LocalDate date;

    public WorkoutLength9(Long duration, int memberId, LocalDate date) {
        this.lengthInMinutes = duration;
        this.memberId = memberId;
        this.date = date;
    }

    public Long getDuration() {
        return lengthInMinutes;
    }

    public void setDuration(Long duration) {
        this.lengthInMinutes = duration;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WorkoutLength{");
        sb.append("duration=").append(lengthInMinutes);
        sb.append(", memberId=").append(memberId);
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
}
