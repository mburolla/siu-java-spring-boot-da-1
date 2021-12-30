package com.xpanxion.java.springboot.da1.demo.repository.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Gym9;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymRepository9  extends JpaRepository<Gym9, Integer> {

    List<Gym9> findByNameContaining(String name);



}
