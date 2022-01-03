package com.xpanxion.java.springboot.da1.demo.model.student2;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "MEMBER2")
public class Member2 {

    //
    // Data members
    //

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private Date subscriptionStart;
    private Date subscriptionEnd;

    @ManyToOne(targetEntity = Gym2.class)
    @JoinColumn(name = "gymId", referencedColumnName = "id")
    private Gym2 gym2;

    //
    // Constructors
    //

    public Member2() {
        this.id = -1;
        this.firstName = "";
        this.lastName = "";
        this.birthday = new Date(0);
        this.subscriptionStart = new Date(0);
        this.subscriptionEnd = new Date(0);
    }

    public Member2(int id, String firstName,
                   String lastName, long birthdayLong,
                   long subStartLong, long subEndLong) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = new Date(birthdayLong);
        this.subscriptionStart = new Date(subStartLong);
        this.subscriptionEnd = new Date(subEndLong);
    }

    //
    // Getter
    //

    public Gym2 getGym2() {
        return gym2;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Date getSubscriptionStart() {
        return subscriptionStart;
    }

    public Date getSubscriptionEnd() {
        return subscriptionEnd;
    }

    //
    // Setters
    //


    public void setGym2(Gym2 gym2) {
        this.gym2 = gym2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(long birthdayLong) {
        this.birthday = new Date(birthdayLong);
    }

    public void setSubscriptionStart(long subStartLong) {
        this.subscriptionStart = new Date(subStartLong);
    }

    public void setSubscriptionEnd(long subEndLong) {
        this.subscriptionEnd = new Date(subEndLong);
    }
}
