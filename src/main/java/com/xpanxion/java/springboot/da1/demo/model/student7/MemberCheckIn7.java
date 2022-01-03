package com.xpanxion.java.springboot.da1.demo.model.student7;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Member_Check_In7")
public class MemberCheckIn7 {

    @ManyToOne(
            targetEntity = Member7.class,
            cascade= CascadeType.ALL
    )
    @JoinColumn(
            name ="member_id",
            referencedColumnName = "memberId"
    )
  private  Member7 memberId;

    @Id
    @GeneratedValue
    private int memberCheckInId;
    private Date timeUtc;
    private String checkType;


    public MemberCheckIn7(){
    }

    public MemberCheckIn7(Member7 memberId, Date timeUtc, String checkType) {
        this.timeUtc=timeUtc;
        this.checkType=checkType;
        this.memberId=memberId;
    }

    public Date getTimeUtc() {
        return timeUtc;
    }

    public void setTimeUtc(Date timeUtc) {
        this.timeUtc = timeUtc;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public Member7 getMemberId() {
        return memberId;
    }

    public void setMemberId(Member7 memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "MemberCheckIn{" +
                "timeUtc=" + timeUtc +
                ", checkType='" + checkType + '\'' +
                ", memberId=" + memberId +
                '}';
    }
}
