package com.xpanxion.java.springboot.da1.demo.model.student3;

import javax.persistence.*;

@Entity
@Table(name = "MEMBER3")
public class Member3 {

    //
    //Data members
    //


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
    private int memberId;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Gym3.class)
    @JoinColumn(name = "gym_id", referencedColumnName = "gymId")
    private Gym3 gym;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String subStartDate;
    private String subEndDate;

    //
    //Constructors
    //

    public Member3(){
    }

    public Member3(Integer memberId, Gym3 gym, String firstName, String lastName, String dateOfBirth, String subStartDate, String subEndDate){
        this.memberId = memberId;
        this.gym = gym;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.subStartDate = subStartDate;
        this.subEndDate = subEndDate;
    }

    //
    //Accessors
    //


    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Gym3 getGym() {
        return gym;
    }

    public void setGym(Gym3 gym) {
        this.gym = gym;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSubStartDate() {
        return subStartDate;
    }

    public void setSubStartDate(String subStartDate) {
        this.subStartDate = subStartDate;
    }

    public String getSubEndDate() {
        return subEndDate;
    }

    public void setSubEndDate(String subEndDate) {
        this.subEndDate = subEndDate;
    }
}
