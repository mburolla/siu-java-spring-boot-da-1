package com.xpanxion.java.springboot.da1.demo.repository.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.Gym5;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymRepository5 extends JpaRepository<Gym5, Integer> {
    List<Gym5> findAllByNameContaining(String name);
}
