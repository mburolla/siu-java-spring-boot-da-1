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
    private long gymId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String subStartDate;
    private String subEndDate;

    //
    //Constructors
    //

    public Member3(){
        this.memberId = -1;
        this.gymId = -1L;
        this.firstName = "";
        this.lastName = "";
        this.dateOfBirth = "";
        this.subStartDate = "";
        this.subEndDate = "";
    }

    public Member3(Integer memberId, String firstName, String lastName, String dateOfBirth, String subStartDate, String subEndDate){
        this.memberId = memberId;
        this.gymId = -1L;
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

    public long getGymId() {
        return gymId;
    }

    public void setGymId(long gymId) {
        this.gymId = gymId;
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
