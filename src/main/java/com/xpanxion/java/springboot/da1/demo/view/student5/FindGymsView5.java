package com.xpanxion.java.springboot.da1.demo.view.student5;

public class FindGymsView5 {
    private Long id;
    private String name;

    public FindGymsView5() {
    }

    public FindGymsView5(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
