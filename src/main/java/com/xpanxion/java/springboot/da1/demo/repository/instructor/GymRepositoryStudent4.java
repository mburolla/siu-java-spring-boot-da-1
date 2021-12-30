package com.xpanxion.java.springboot.da1.demo.repository.instructor;

import com.xpanxion.java.springboot.da1.demo.model.student4.Gym4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymRepositoryStudent4  extends JpaRepository<Gym4, Integer> {
     List<Gym4> findByNameContaining(String name);
}
