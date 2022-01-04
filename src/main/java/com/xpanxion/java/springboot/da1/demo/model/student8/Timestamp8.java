package com.xpanxion.java.springboot.da1.demo.model.student8;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="timestamp8")
public class Timestamp8 {

    // DATA

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int timestampId;
    private int memberId;
    private Timestamp checkInTime;
    private Timestamp checkOutTime;

    // CONSTRUCTORS

    public Timestamp8() {}

    public Timestamp8(int memberId, Timestamp checkInTime) {
        this.memberId = memberId;
        this.checkInTime = checkInTime;
        this.checkOutTime = null;
    }

    public Timestamp8(int timestampId, int memberId, Timestamp checkInTime, Timestamp checkOutTime) {
        this.timestampId = timestampId;
        this.memberId = memberId;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }

    // ACCESSORS

    public int getTimestampId() {
        return timestampId;
    }

    public void setTimestampId(int timestampId) {
        this.timestampId = timestampId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Timestamp getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Timestamp checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Timestamp getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Timestamp checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}
