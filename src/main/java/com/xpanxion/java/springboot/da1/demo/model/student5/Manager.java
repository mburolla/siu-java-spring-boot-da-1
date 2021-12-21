package com.xpanxion.java.springboot.da1.demo.model.student5;

public class Manager {
    private int managerId;
    private String fullName;

    public Manager() {
        this.managerId = -1;
        this.fullName = "";
    }

    public Manager(int managerId, String fullName) {
        this.managerId = managerId;
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
