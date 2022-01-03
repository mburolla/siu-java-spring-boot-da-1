package com.xpanxion.java.springboot.da1.demo.repository.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.WorkoutHistory5;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutHistoryRepository5 extends JpaRepository<WorkoutHistory5, Long> {
    List<WorkoutHistory5> findAllByMemberMemberIdOrderByWorkoutIdDesc(Long memberId);
    List<WorkoutHistory5> findAllByMemberMemberId(Long memberId);
}
