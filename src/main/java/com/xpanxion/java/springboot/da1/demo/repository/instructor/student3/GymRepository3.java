package com.xpanxion.java.springboot.da1.demo.repository.instructor.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository3 extends JpaRepository<Gym, Integer>{


}
