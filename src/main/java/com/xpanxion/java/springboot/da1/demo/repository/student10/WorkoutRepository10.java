package com.xpanxion.java.springboot.da1.demo.repository.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.Workout10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkoutRepository10 extends JpaRepository<Workout10, Integer> {

    Workout10 findTopByMemberIdOrderByWorkoutIdDesc(int memberId);

    List<Workout10> findAllByMemberId(int memberId);
}