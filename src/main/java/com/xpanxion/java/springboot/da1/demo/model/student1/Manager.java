package com.xpanxion.java.springboot.da1.demo.model.student1;

public class Manager {

    private int managerId;
    private String fullName;

    public Manager(int id, String fullName) {
        this.managerId = id;
        this.fullName = fullName;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
