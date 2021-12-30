package com.xpanxion.java.springboot.da1.demo.model.student5;

import javax.persistence.*;

@Entity
@Table(name="gym5")
public class Gym5 {

    @Id
    @SequenceGenerator(
            name = "gym_sequence",
            sequenceName = "gym_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "gym_sequence"
    )
    private Long id;
    private String name;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;

    public Gym5() {
        this.id = -1l;
        this.name = "";
        this.street1 = "";
        this.street2 = "";
        this.city = "";
        this.state = "";
        this.zip = "";
    }

    public Gym5(String name, String street1, String street2, String city, String state, String zip) {
        this.name = name;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "Gym5{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
