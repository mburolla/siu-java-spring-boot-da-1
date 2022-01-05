package com.xpanxion.java.springboot.da1.demo.model.student8;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="member_history8")
public class MemberHistory8 {

    // DATA
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int historyID;
    @OneToOne(
            targetEntity = Member8.class,
            cascade= CascadeType.ALL
    )
    @JoinColumn(
            name ="member_id",
            referencedColumnName = "memberId"
    )
    private Member8 member;
    private Timestamp timeUtc;
    private CheckInOutType8 checkType;

    // CONSTRUCTORS

    public MemberHistory8() {}

    public MemberHistory8(Member8 member, Timestamp timeUtc, CheckInOutType8 checkType) {
        this.member = member;
        this.timeUtc = timeUtc;
        this.checkType = checkType;
    }

    public MemberHistory8(int historyID, Member8 member, Timestamp timeUtc, CheckInOutType8 checkType) {
        this.historyID = historyID;
        this.member = member;
        this.timeUtc = timeUtc;
        this.checkType = checkType;
    }

    // ACCESSORS

    public int getHistoryID() {
        return historyID;
    }

    public void setHistoryID(int historyID) {
        this.historyID = historyID;
    }

    public Member8 getMember() {
        return member;
    }

    public void setMember(Member8 member) {
        this.member = member;
    }

    public Timestamp getTimeUtc() {
        return timeUtc;
    }

    public void setTimeUtc(Timestamp timeUtc) {
        this.timeUtc = timeUtc;
    }

    public CheckInOutType8 getCheckType() {
        return checkType;
    }

    public void setCheckType(CheckInOutType8 checkType) {
        this.checkType = checkType;
    }
}
