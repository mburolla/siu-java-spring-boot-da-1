package com.xpanxion.java.springboot.da1.demo.repository.instructor.student10;

import com.xpanxion.java.springboot.da1.demo.model.instructor.Product;
import com.xpanxion.java.springboot.da1.demo.model.student10.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository extends JpaRepository<Gym, Integer> {
}