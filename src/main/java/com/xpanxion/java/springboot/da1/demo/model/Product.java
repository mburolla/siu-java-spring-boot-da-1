package com.xpanxion.java.springboot.da1.demo.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="PRODUCT")
public class Product {

    //
    // Data members
    //

    @Id
    // @GeneratedValue // Commented for the one-to-many example.
    private int id;
    private String name;
    private int quantity;
    private double price;

    //
    // Constructors
    //

    public Product() { // Required.
        this.id = -1;
        this.name = "";
        this.quantity = -1;
        this.price = -1;
    }

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    //
    // Accessors
    //

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
