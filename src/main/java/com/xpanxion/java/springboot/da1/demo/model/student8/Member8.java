package com.xpanxion.java.springboot.da1.demo.model.student8;

import javax.persistence.*;

@Entity
@Table(name="member8")
public class Member8 {

    // DATA

    @Id
    int memberId;
    int gymId;
    String firstName;
    String lastName;
    String dateOfBirth;
    String subscriptionStartDate;
    String subscriptionEndDate;

    // CONSTRUCTORS

    public Member8() {}

    public Member8(int memberId, int gymId, String firstName, String lastName, String dateOfBirth, String subscriptionStartDate, String subscriptionEndDate) {
        this.memberId = memberId;
        this.gymId = gymId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.subscriptionStartDate = subscriptionStartDate;
        this.subscriptionEndDate = subscriptionEndDate;
    }

    // ACCESSORS

    public int getMemberId() {
        return memberId;
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

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public String getSubscriptionEndDate() {
        return subscriptionEndDate;
    }
}
