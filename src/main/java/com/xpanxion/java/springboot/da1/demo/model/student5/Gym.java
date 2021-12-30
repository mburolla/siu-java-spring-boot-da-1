package com.xpanxion.java.springboot.da1.demo.model.student5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GYM")
public class Gym {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;

    public Gym() {
        this.id = -1;
        this.name = "";
        this.street1 = "";
        this.street2 = "";
        this.city = "";
        this.state = "";
        this.zip = "";
    }

    public Gym(Integer id, String name, String street1, String street2, String city, String state, String zip) {
        this.id = id;
        this.name = name;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}