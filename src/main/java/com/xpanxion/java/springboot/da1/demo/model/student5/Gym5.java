package com.xpanxion.java.springboot.da1.demo.model.student5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="gym5")
public class Gym5 {

    @Id
    private Long id;
    private String name;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;
}
