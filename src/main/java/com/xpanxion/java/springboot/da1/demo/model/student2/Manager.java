package com.xpanxion.java.springboot.da1.demo.model.student2;

public class Manager {

    private int id;
    private String full_name;

    public Manager(int id, String full_name) {
        this.id = id;
        this.full_name = full_name;
    }

    public int getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
