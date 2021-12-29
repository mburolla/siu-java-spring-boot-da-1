package com.xpanxion.java.springboot.da1.demo.repository.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository5 extends JpaRepository<Gym, Integer> { }
