package com.xpanxion.java.springboot.da1.demo.repository.student6;

import com.xpanxion.java.springboot.da1.demo.model.student6.Gym6;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymRepository6 extends JpaRepository<Gym6, Integer> {

   public Gym6 findByFirstname(String name);
}
