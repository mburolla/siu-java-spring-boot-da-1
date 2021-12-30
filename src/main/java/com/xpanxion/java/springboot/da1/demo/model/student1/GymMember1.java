package com.xpanxion.java.springboot.da1.demo.model.student1;

import javax.persistence.*;
import java.text.DateFormat;

@Entity
@Table(name="gymMember1")
public class GymMember1 {

    @Id
    @SequenceGenerator(
            name = "student1_sequence",
            sequenceName = "student1_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student1_sequence"
    )
    private int id;
    private String firstName;
    private String lastName;
    private String dob;
    private String subscriptionStart;
    private String subscriptionEnd;

    public GymMember1() {};

    public GymMember1(int id, String firstName, String lastName, String dob, String subscriptionStart, String subscriptionEnd) {
        this.id = id;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSubscriptionStart() {
        return subscriptionStart;
    }

    public void setSubscriptionStart(String subscriptionStart) {
        this.subscriptionStart = subscriptionStart;
    }

    public String getSubscriptionEnd() {
        return subscriptionEnd;
    }

    public void setSubscriptionEnd(String subscriptionEnd) {
        this.subscriptionEnd = subscriptionEnd;
    }
}
