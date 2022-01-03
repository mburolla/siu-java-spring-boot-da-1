package com.xpanxion.java.springboot.da1.demo.model.student9;


import javax.persistence.*;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "MemberHistory9")
public class MemberHistory9 {
    @Id
    @SequenceGenerator(
            name = "member_history_sequence",
            sequenceName = "member_history_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_history_sequence"
    )
    private int historyId;
    @OneToOne(
            targetEntity = Member9.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "memberId",
            referencedColumnName = "memberId"
    )
    private Member9 member;

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public MemberHistory9() {}


    public MemberHistory9(Member9 member9) {
        this.member = member9;
    }


    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public Member9 getMemberId() {
        return member;
    }

    public void setMemberId(Member9 memberId) {
        this.member = memberId;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }
}
