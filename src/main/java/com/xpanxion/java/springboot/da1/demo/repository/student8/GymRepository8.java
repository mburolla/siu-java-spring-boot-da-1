package com.xpanxion.java.springboot.da1.demo.repository.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Gym8;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GymRepository8 extends JpaRepository<Gym8, Integer> {

    List<Gym8> findByNameContaining(String name);

    Optional<Gym8> findById(Integer gymId);

}
