package com.xpanxion.java.springboot.da1.demo.controller.student6.repository;

import com.xpanxion.java.springboot.da1.demo.controller.student6.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository extends JpaRepository<Gym, Integer> {
}
