package com.xpanxion.java.springboot.da1.demo.model.student9;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Manager {
    private String full_name;

    public Manager() {}

    public Manager(@JsonProperty("name") String full_name){
        this.full_name = full_name;
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
        sb.append("full_name='").append(full_name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
