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
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Member3.class)
    @JoinColumn(name = "member_id", referencedColumnName = "memberId")
    private Member3 member;
    private String time;
    private CheckType3 checkType;


    //
    //Constructors
    //

    public CheckInOut3() {

    }

    public CheckInOut3(Member3 member, CheckType3 checkType, String time) {
        this.member = member;
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

    public Member3 getMember() {
        return member;
    }

    public void setMember(Member3 member) {
        this.member = member;
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

