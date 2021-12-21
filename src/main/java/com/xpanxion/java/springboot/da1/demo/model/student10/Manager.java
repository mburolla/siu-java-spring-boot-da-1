package com.xpanxion.java.springboot.da1.demo.model.student10;

public class Manager {

    private int manager_id;
    private String full_name;

    public Manager(int manager_id, String full_name) {
        this.manager_id = manager_id;
        this.full_name = full_name;
    }

    public int getManager_id() {
        return manager_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

}
