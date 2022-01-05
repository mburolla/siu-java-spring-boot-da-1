package com.xpanxion.java.springboot.da1.demo.repository.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Workout4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutHistoryRepository4 extends JpaRepository<Workout4, Long> {
    List<Workout4> findAllByMemberMemberIdOrderByWorkoutIdDesc(Long memberId);
}
