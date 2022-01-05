package com.xpanxion.java.springboot.da1.demo.repository.student6;

import com.xpanxion.java.springboot.da1.demo.model.student6.WorkoutHistory6;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutHistoryRepository6 extends JpaRepository<WorkoutHistory6, Integer> {
}
