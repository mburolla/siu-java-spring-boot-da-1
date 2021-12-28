package com.xpanxion.java.springboot.da1.demo.model.student3;

public class BookStore {

    private int managerId;
    private String name;

    public BookStore(int managerId, String name){
        this.managerId = managerId;
        this.name = name;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "managerId=" + managerId +
                ", name='" + name + '\'' +
                '}';
    }
}

