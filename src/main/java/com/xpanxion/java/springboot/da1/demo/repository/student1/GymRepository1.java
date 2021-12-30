package com.xpanxion.java.springboot.da1.demo.repository.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Gym1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface GymRepository1 extends JpaRepository<Gym1, Integer> {

    List<Gym1> findByNameContaining(String name);

    Optional<Gym1> findById(int gymId);

}
