package com.xpanxion.java.springboot.da1.demo.repository.instructor;

import com.xpanxion.java.springboot.da1.demo.model.student4.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepositoryStudent4  extends JpaRepository<Gym, Integer> {
}

