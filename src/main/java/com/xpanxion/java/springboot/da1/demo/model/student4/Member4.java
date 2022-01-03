package com.xpanxion.java.springboot.da1.demo.model.student4;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "Member4")
public class Member4 {

    @Id
    @SequenceGenerator(
            name = "member_sequence",
            sequenceName = "member_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_sequence"
    )

    private long id;
    private long gymId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date subscriptionStart;
    private Date subscriptionEnd;

    public Member4() {
        this.id = -1L;
        this.gymId = -1L;
        this.firstName = "";
        this.lastName = "";
        this.dateOfBirth = new Date();
        this.subscriptionStart = new Date();
        this.subscriptionEnd = new Date();
    }

    public Member4(long id,
                   String firstName,
                   String lastName,
                   Date dateOfBirth,
                   Date subscriptionStart,
                   Date subscriptionEnd) {
        this.id = id;
        this.gymId = -1L;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.subscriptionStart = subscriptionStart;
        this.subscriptionEnd = subscriptionEnd;
    }

    @Override
    public String toString() {
        return "Member5{" +
                "id=" + id +
                ", gymId=" + gymId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", subscriptionStart=" + subscriptionStart +
                ", subscriptionEnd=" + subscriptionEnd +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGymId() {
        return gymId;
    }

    public void setGymId(long gymId) {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getSubscriptionStart() {
        return subscriptionStart;
    }

    public void setSubscriptionStart(Date subscriptionStart) {
        this.subscriptionStart = subscriptionStart;
    }

    public Date getSubscriptionEnd() {
        return subscriptionEnd;
    }

    public void setSubscriptionEnd(Date subscriptionEnd) {
        this.subscriptionEnd = subscriptionEnd;
    }
}