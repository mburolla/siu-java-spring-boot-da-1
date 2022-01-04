package com.xpanxion.java.springboot.da1.demo.repository.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.WorkoutHistory4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutHistoryRepositoryStudent4 extends JpaRepository<WorkoutHistory4, Long>{
    List<WorkoutHistory4> findAllByMemberMemberId(Long Id);
}
