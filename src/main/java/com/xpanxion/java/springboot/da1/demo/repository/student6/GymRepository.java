package com.xpanxion.java.springboot.da1.demo.repository.student6;

import com.xpanxion.java.springboot.da1.demo.model.student6.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository extends JpaRepository<Gym, Integer> {
}
