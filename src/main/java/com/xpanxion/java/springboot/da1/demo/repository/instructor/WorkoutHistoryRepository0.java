package com.xpanxion.java.springboot.da1.demo.repository.instructor;

import com.xpanxion.java.springboot.da1.demo.model.instructor.WorkoutHistory0;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkoutHistoryRepository0 extends JpaRepository<WorkoutHistory0, Integer> {

    final String SELECT_WORKOUT_HISTORY = "select * from workout_history0 where member_id = :memberId";

    @Query(value = SELECT_WORKOUT_HISTORY, nativeQuery = true)
    List<WorkoutHistory0> getWorkoutHistoryForMember(Integer memberId);
}
