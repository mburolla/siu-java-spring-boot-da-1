package com.xpanxion.java.springboot.da1.demo.model.student9;

import javax.persistence.*;
import java.time.DateTimeException;
import java.util.Date;
@Entity
@Table(name= "Member9")
public class Member9 {

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
    @OneToOne(
            targetEntity = Gym9.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "gym",
            referencedColumnName = "id"

    )
    private Gym9 gym;
    private String firstName;
    private String lastName;
    private String DOB;
    private Date startDate;
    private Date endDate;

    public Member9() {}

    public Member9(Gym9 id, String firstName, String lastName, String DOB, Date startDate, Date endDate) {
        this.gym = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Member9(String firstName, String lastName, String DOB, Date startDate, Date endDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Gym9 getGym() {
        return gym;
    }

    public void setGym(Gym9 gymId) {
        this.gym = gymId;
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

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
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
