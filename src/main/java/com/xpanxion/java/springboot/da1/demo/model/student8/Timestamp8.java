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

    @OneToOne(
            targetEntity = Member8.class,
            cascade= CascadeType.ALL
    )
    @JoinColumn(
            name ="member_id",
            referencedColumnName = "memberId"
    )
    private Member8 member;
    private Timestamp checkInTime;
    private Timestamp checkOutTime;

    // CONSTRUCTORS

    public Timestamp8() {}

    public Timestamp8(Member8 member, Timestamp checkInTime) {
        this.member = member;
        this.checkInTime = checkInTime;
        this.checkOutTime = null;
    }

    public Timestamp8(int timestampId, Member8 member, Timestamp checkInTime, Timestamp checkOutTime) {
        this.timestampId = timestampId;
        this.member = member;
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

    public void setmember(Member8 member) {
        this.member = member;
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
