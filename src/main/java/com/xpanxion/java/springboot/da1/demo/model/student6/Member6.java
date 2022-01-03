package com.xpanxion.java.springboot.da1.demo.model.student6;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Member6 {

    @OneToOne
    private Gym6 gym6;

    //MEM VARS
    private int id;
    private int gymId;
    private String firstname;
    private String lastname;
    private Date dob;
    private Date subStartDate;
    private Date subEndDate;

    //CONSTRUCTOR
    public Member6(int id, int gymId, String firstname, String lastname, Date dob, Date subStartDate, Date subEndDate) {
        this.id = id;
        this.gymId = gymId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.subStartDate = subStartDate;
        this.subEndDate = subEndDate;
    }

    //GETTERS AND SETTERS

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getSubStartDate() {
        return subStartDate;
    }

    public void setSubStartDate(Date subStartDate) {
        this.subStartDate = subStartDate;
    }

    public Date getSubEndDate() {
        return subEndDate;
    }

    public void setSubEndDate(Date subEndDate) {
        this.subEndDate = subEndDate;
    }
}
