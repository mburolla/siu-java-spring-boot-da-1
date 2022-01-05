package com.xpanxion.java.springboot.da1.demo.repository.instructor;

import com.xpanxion.java.springboot.da1.demo.model.instructor.Gym0;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymRepository0 extends JpaRepository<Gym0, Integer> {

    List<Gym0> findByNameAndZip(String name, int zip);
}
