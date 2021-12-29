package com.xpanxion.java.springboot.da1.demo.repository.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository2 extends JpaRepository <Gym,Integer>{ }
