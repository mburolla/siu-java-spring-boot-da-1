package com.xpanxion.java.springboot.da1.demo.repository.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.Gym3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository3 extends JpaRepository<Gym3, Integer>{


}
