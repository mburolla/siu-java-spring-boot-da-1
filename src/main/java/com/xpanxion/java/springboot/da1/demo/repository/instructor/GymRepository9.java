package com.xpanxion.java.springboot.da1.demo.repository.instructor;

import com.xpanxion.java.springboot.da1.demo.model.student9.Gym9;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository9  extends JpaRepository<Gym9, Integer> {

}
