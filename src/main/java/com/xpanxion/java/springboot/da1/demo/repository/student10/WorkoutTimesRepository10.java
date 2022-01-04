package com.xpanxion.java.springboot.da1.demo.repository.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.WorkoutTimes10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutTimesRepository10 extends JpaRepository<WorkoutTimes10, Long> {
    List<WorkoutTimes10> findAllByMemberId(int memberId);
}