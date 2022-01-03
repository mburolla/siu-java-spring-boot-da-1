package com.xpanxion.java.springboot.da1.demo.model.student2;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "HISTORY2")
public class History2 {

    //
    // Data Members
    //

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private Timestamp checkin;
    private Timestamp checkout;

    @ManyToOne(targetEntity = Member2.class)
    @JoinColumn(name = "memberId", referencedColumnName = "id", nullable = false)
    private Member2 member2;

    //
    // Constructors
    //

    public History2() {
        this.checkin = new Timestamp(0, 0, 0, 0, 0, 0, 0);
        this.checkout = new Timestamp(0, 0, 0, 0, 0, 0, 0);
    }

    public History2(int id, Timestamp checkin, Timestamp checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
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

    public Timestamp getCheckout() {
        return checkout;
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

    public void setCheckout(Timestamp checkout) {
        this.checkout = checkout;
    }
}
