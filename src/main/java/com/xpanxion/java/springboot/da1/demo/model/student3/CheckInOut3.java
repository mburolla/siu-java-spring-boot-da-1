package com.xpanxion.java.springboot.da1.demo.model.student3;

import org.hibernate.annotations.Check;

import javax.persistence.*;

@Entity
@Table(name = "CHECK_IN_OUT3")
public class CheckInOut3 {

    //
    //Data members
    //

    @Id
    @SequenceGenerator(
            name = "clock_sequence",
            sequenceName = "clock_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "clock_sequence"
    )
    private long checkInId;
    private long memberId;
    private String time;
    private CheckType3 checkType;


    //
    //Constructors
    //

    public CheckInOut3() { }

    public CheckInOut3(long memberId, CheckType3 checkType, String time) {
        this.memberId = memberId;
        this.checkType = checkType;
        this.time = time;
    }

    //
    //Accessors
    //

    public long getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(long checkInId) {
        this.checkInId = checkInId;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public CheckType3 getCheckType() {
        return checkType;
    }

    public void setCheckType(CheckType3 checkType) {
        this.checkType = checkType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

