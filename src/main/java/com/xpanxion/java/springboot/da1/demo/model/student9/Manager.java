package com.xpanxion.java.springboot.da1.demo.model.student9;

public class Manager {
    private int manager_id;
    private String full_name;

    public Manager() {}

    public Manager(int manager_id, String full_name){
        this.manager_id = manager_id;
        this.full_name = full_name;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Manager{");
        sb.append("manager_id=").append(manager_id);
        sb.append(", full_name='").append(full_name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
