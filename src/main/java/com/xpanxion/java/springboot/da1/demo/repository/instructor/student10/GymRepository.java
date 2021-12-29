package com.xpanxion.java.springboot.da1.demo.repository.instructor.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.Gym10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository extends JpaRepository<Gym10, Integer> {
}