package com.xpanxion.java.springboot.da1.demo.repository.instructor.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.Gym3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymRepository3 extends JpaRepository<Gym3, Integer>{

    List<Gym3> findByNameContaining(String name);


}
