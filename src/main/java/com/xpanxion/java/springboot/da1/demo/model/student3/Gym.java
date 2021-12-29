package com.xpanxion.java.springboot.da1.demo.model.student3;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GYM")
public class Gym {

    //
    //Data members
    //

    @Id
    private int gymId;
    private String name;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private int zip;

    //
    //Constructors
    //

    public Gym(){
        this.gymId = -1;
        this.name = "";
        this.street1 = "";
        this.street2 = "";
        this.city = "";
        this.state = "";
        this.zip = -1;
    }

    public Gym(int gymId, String name, String street1, String street2, String city, String state, int zip){
        this.gymId = gymId;
        this.name = name;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    //
    //Accessors
    //


    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
}
