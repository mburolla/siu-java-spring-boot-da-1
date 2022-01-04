package com.xpanxion.java.springboot.da1.demo.model.student1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "workout")
public class Workout {

    @Id
    private int id;
    private int memberId;
    private Date date;

    public Workout(int id, int memberId, Date date) {
        this.id = id;
        this.memberId = memberId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
