package com.xpanxion.java.springboot.da1.demo.model.student8;
import javax.persistence.*;

@Entity
@Table(name="member8")
public class Member8 {

    // DATA

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
    @ManyToOne(
            targetEntity = Gym8.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "gym_id",
            referencedColumnName = "id"
    )
    private Gym8 gym;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String subscriptionStartDate;
    private String subscriptionEndDate;

    // CONSTRUCTORS

    public Member8() {}

    public Member8(int memberId, Gym8 id, String firstName, String lastName, String dateOfBirth, String subscriptionStartDate, String subscriptionEndDate) {
        this.memberId = memberId;
        this.gym = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.subscriptionStartDate = subscriptionStartDate;
        this.subscriptionEndDate = subscriptionEndDate;
    }

    // ACCESSORS

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Gym8 getGym() {
        return gym;
    }

    public void setGym(Gym8 gym) {
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

    public String getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public void setSubscriptionStartDate(String subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public String getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public void setSubscriptionEndDate(String subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }
}
