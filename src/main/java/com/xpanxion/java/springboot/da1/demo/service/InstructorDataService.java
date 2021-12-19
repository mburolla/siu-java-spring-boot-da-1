package com.xpanxion.java.springboot.da1.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.xpanxion.java.springboot.da1.demo.model.instructor.Product;
import com.xpanxion.java.springboot.da1.demo.repository.InstructorProductRepository;

import java.util.List;

@Service
public class InstructorDataService {

    //
    // Data members
    //

    @Autowired
    private InstructorProductRepository instructorProductRepository;

    //
    // Product Methods
    //

    public List<Product> getProducts() {
        return instructorProductRepository.findAll();
    }

    public void addProduct() {
        var p = new Product(1, "test", 1, 11);
        instructorProductRepository.save(p);
    }
}
