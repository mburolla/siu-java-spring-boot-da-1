package com.xpanxion.java.springboot.da1.demo.model.student8;

public class Manager {

    // DATA

    int id;
    String fullName;

    // CONSTRUCTORS

    public Manager() {}

    public Manager(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    // ACCESSORS

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    // OVERRIDES

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }

}
