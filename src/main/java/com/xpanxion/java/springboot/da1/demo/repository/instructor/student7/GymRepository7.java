package com.xpanxion.java.springboot.da1.demo.repository.instructor.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.Gym7;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository7 extends JpaRepository<Gym7, Integer> {
}
