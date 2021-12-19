package com.xpanxion.java.springboot.da1.demo.repository;

import org.springframework.stereotype.Repository;
import com.xpanxion.java.springboot.da1.demo.model.instructor.Product;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InstructorProductRepository extends JpaRepository<Product, Integer> {

}
