package com.xpanxion.java.springboot.da1.demo.model.student1;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "timestamps1")
public class Timestamps1 {

    @Id
    @SequenceGenerator(
            name = "student1_timeStampSequence",
            sequenceName = "student1_timeStampSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student1_timeStampSequence"
    )
    private int id;
    private int memberId;
    private Date checkIn;
    private Date checkOut;

    public Timestamps1() {}

    public Timestamps1(int id, int memberId, Date checkIn, Date checkOut) {
        this.id = id;
        this.memberId = memberId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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
