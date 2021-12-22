package com.xpanxion.java.springboot.da1.demo.model.student8;

public class Manager {

    int id;
    String fullName;

    public Manager(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
