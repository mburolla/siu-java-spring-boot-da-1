package com.xpanxion.java.springboot.da1.demo.repository.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.Gym10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymRepository10 extends JpaRepository<Gym10, Integer> {

    List<Gym10> findByNameLike(String gymName);

    Gym10 findById(int id);
}