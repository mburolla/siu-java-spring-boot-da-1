package com.xpanxion.java.springboot.da1.demo.service.instructor;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.xpanxion.java.springboot.da1.demo.model.instructor.Product;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.ProductRepository;

import java.util.List;

@Service
public class DataService {

    //
    // Data members
    //

    @Autowired
    private ProductRepository instructorProductRepository;

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
