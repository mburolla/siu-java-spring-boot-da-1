package com.xpanxion.java.springboot.da1.demo.model.student5;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="member5")
public class Member5 {

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
    private Long memberId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date subscriptionStart;
    private Date subscriptionEnd;

    @OneToOne
    @JoinColumn(
            name = "gym_id",
            referencedColumnName = "gymId"
    )
    private Gym5 gym;

    public Member5() {
    }

    public Member5(Gym5 gym) {
        this.gym = gym;
    }

    public Member5(Long memberId, String firstName, String lastName, Date dateOfBirth, Date subscriptionStart, Date subscriptionEnd, Gym5 gym) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.subscriptionStart = subscriptionStart;
        this.subscriptionEnd = subscriptionEnd;
        this.gym = gym;
    }

    @Override
    public String toString() {
        return "Member5{" +
                "memberId=" + memberId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", subscriptionStart=" + subscriptionStart +
                ", subscriptionEnd=" + subscriptionEnd +
                ", gym=" + gym +
                '}';
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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

    public Gym5 getGym() {
        return gym;
    }

    public void setGym(Gym5 gym) {
        this.gym = gym;
    }
}
