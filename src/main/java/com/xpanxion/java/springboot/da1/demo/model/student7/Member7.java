package com.xpanxion.java.springboot.da1.demo.model.student7;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Member7")
public class Member7 {

        @Id
    @SequenceGenerator(
            name = "member7_sequence",
            sequenceName = "member7_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member7_sequence"
    )
    private int memberId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date startOfSub;
    private Date endOfSub;


    @ManyToOne(
            targetEntity = Gym7.class,
            cascade= CascadeType.ALL
    )
    @JoinColumn(
            name ="gym_id",
            referencedColumnName = "id"
    )
    private Gym7 gym;


    public Member7() {

    }

    public Member7(String firstName, String lastName, Date dateOfBirth, Date startOfSub, Date endOfSub, Gym7 gym) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.dateOfBirth=dateOfBirth;
        this.startOfSub=startOfSub;
        this.endOfSub=endOfSub;
        this.gym=gym;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getStartOfSub() {
        return startOfSub;
    }

    public void setStartOfSub(Date startOfSub) {
        this.startOfSub = startOfSub;
    }

    public Date getEndOfSub() {
        return endOfSub;
    }

    public void setEndOfSub(Date endOfSub) {
        this.endOfSub = endOfSub;
    }

    public Gym7 getGym() {
        return gym;
    }

    public void setGym(Gym7 gym) {
        this.gym = gym;
    }

    @Override
    public String toString() {
        return "Member7{" +
                "memberId=" + memberId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", startOfSub=" + startOfSub +
                ", endOfSub=" + endOfSub +
                ", gym=" + gym +
                '}';
    }
}
