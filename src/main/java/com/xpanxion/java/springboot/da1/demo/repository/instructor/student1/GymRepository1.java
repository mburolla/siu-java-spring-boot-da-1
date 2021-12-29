package com.xpanxion.java.springboot.da1.demo.repository.instructor.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository1 extends JpaRepository<Gym, Integer> {
}
