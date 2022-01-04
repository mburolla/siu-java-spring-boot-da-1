package com.xpanxion.java.springboot.da1.demo.repository.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Member4;
import com.xpanxion.java.springboot.da1.demo.model.student4.Workout4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository4 extends JpaRepository<Workout4, Integer> {
    // Workout4 findTopByMemberId(long memberId);
    List<Workout4> findByMember(Member4 member);
}
