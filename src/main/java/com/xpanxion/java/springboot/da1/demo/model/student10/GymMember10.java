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
    private String dateOfBirth;
    private String startDate;
    private String endDate;

//    @ManyToOne(targetEntity = Gym10.class)
//    @JoinColumn(name = "gymId", referencedColumnName = "id")
//    private Gym10 gym;

    public GymMember10(){
        this.id = -1;
        this.firstName = "";
        this.lastName = "";
        this.dateOfBirth = "";
        this.startDate = "";
        this.endDate = "";
    }

    public GymMember10(int id, Gym10 gym, String firstName, String lastName, String dateOfBirth, String startDate, String endDate) {
        this.id = id;
        //this.gym = gym;
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
        return null;
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

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setGym(Gym10 gym) {
        //this.gym = gym;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
