package com.xpanxion.java.springboot.da1.demo.repository.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.WorkoutHistory1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutHistoryRepository1 extends JpaRepository<WorkoutHistory1, Integer> {

//    public List<WorkoutHistory1> findById(int memberId);

}
