package com.xpanxion.java.springboot.da1.demo.model.student10;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="GymMember10")
public class GymMember10 {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date startDate;
    private Date endDate;

    @ManyToOne(targetEntity = Gym10.class)
    @JoinColumn(name = "gymId", referencedColumnName = "id")
    private Gym10 gym;

    public GymMember10(){
        this.id = -1;
        this.firstName = "";
        this.lastName = "";
        this.dateOfBirth = new Date(0);
        this.startDate = new Date(0);
        this.endDate = new Date(0);
    }

    public GymMember10(int id, Gym10 gym, String firstName, String lastName, Date dateOfBirth, Date startDate, Date endDate) {
        this.id = id;
        this.gym = gym;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //Getters
    public int getId() {
        return id;
    }

    public Gym10 getGym() {
        return gym;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setGym(Gym10 gym) {
        this.gym = gym;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
