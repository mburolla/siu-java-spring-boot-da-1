package com.xpanxion.java.springboot.da1.demo.model.instructor;

import com.xpanxion.java.springboot.da1.demo.model.instructor.Gym0;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Member0")
public class Member0 {

    //
    // Data members
    //

    @Id
    @GeneratedValue
    private int memberId;

    @OneToOne(targetEntity = Gym0.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "gym_id", referencedColumnName = "gymId")
    private Gym0 gym;

    private String firstName;
    private String lastName;
    private Date DOB;
    private Date startDate;
    private Date endDate;

    //
    // Constructors
    //

    public Member0() {
    }

    public Member0(Gym0 gym, String firstName, String lastName, Date DOB, Date startDate, Date endDate) {
        this.gym = gym;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Member0(String firstName, String lastName, Date DOB, Date startDate, Date endDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //
    // Accessors
    //

    public Gym0 getGym() {
        return gym;
    }

    public void setGym(Gym0 gym) {
        this.gym = gym;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
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

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
