package com.xpanxion.java.springboot.da1.demo.model.student3;

public class Manager {

    private int id;
    private String fullName;

    public Manager(int id, String fullName){
        this.id = id;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
