package com.xpanxion.java.springboot.da1.demo.model.student3;

import javax.persistence.*;
import java.util.Date;

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
    private int checkType;
    private String time;


    //
    //Constructors
    //

    public CheckInOut3() {
        this.memberId = -1L;
        this.checkType = -1;
        this.time = "";
    }


    public CheckInOut3(long memberId, int checkType, String time) {
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

    public int getCheckType() {
        return checkType;
    }

    public void setCheckType(int checkType) {
        this.checkType = checkType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

