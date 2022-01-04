package com.xpanxion.java.springboot.da1.demo.model.student1;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="gymMember1")
public class GymMember1 {

    @Id
    @SequenceGenerator(
            name = "student1_memberSequence",
            sequenceName = "student1_memberSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student1_memberSequence"
    )
    private int id;
    private int gymId;
    private String firstName;
    private String lastName;
    private Date dob;
    private Date subscriptionStart;
    private Date subscriptionEnd;

    public GymMember1() {};

    public GymMember1(int id, int gymId, String firstName, String lastName, Date dob, Date subscriptionStart, Date subscriptionEnd) {
        this.id = id;
        this.gymId = gymId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.subscriptionStart = subscriptionStart;
        this.subscriptionEnd = subscriptionEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = Date.valueOf(dob);
    }

    public Date getSubscriptionStart() {
        return subscriptionStart;
    }

    public void setSubscriptionStart(String subscriptionStart) {
        this.subscriptionStart = Date.valueOf(subscriptionStart);
    }

    public Date getSubscriptionEnd() {
        return subscriptionEnd;
    }

    public void setSubscriptionEnd(String subscriptionEnd) {
        this.subscriptionEnd = Date.valueOf(subscriptionEnd);
    }
}
