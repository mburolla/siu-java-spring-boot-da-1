package com.xpanxion.java.springboot.da1.demo.repository.instructor;

import com.xpanxion.java.springboot.da1.demo.model.instructor.Member0;
import com.xpanxion.java.springboot.da1.demo.model.instructor.WorkoutHistory0;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutHistoryRepository0 extends JpaRepository<WorkoutHistory0, Integer> {

    List<WorkoutHistory0>findByMember0(Member0 member0);
}
