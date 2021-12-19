package com.xpanxion.java.springboot.da1.demo.repository.instructor;

import org.springframework.stereotype.Repository;
import com.xpanxion.java.springboot.da1.demo.model.instructor.Product;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
