package com.xpanxion.java.springboot.da1.demo.model.student2;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "CHECKIN2")
public class Checkin2 {

    //
    // Data Members
    //

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private Timestamp checkin;

    @ManyToOne(targetEntity = Member2.class)
    @JoinColumn(name = "memberId", referencedColumnName = "id")
    private Member2 member2;

    //
    // Constructors
    //

    public Checkin2() {
        this.checkin = new Timestamp(0, 0, 0, 0, 0, 0, 0);
    }

    public Checkin2(int id, Timestamp checkin) {
        this.checkin = checkin;
    }

    //
    // Getters
    //

    public Member2 getMember2() {
        return member2;
    }

    public int getId() {
        return id;
    }

    public Timestamp getCheckin() {
        return checkin;
    }

    //
    // Setters
    //


    public void setMember2(Member2 member2) {
        this.member2 = member2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCheckin(Timestamp checkin) {
        this.checkin = checkin;
    }
}
