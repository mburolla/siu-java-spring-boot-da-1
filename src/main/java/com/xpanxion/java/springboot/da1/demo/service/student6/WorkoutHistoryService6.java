package com.xpanxion.java.springboot.da1.demo.service.student6;

import com.xpanxion.java.springboot.da1.demo.model.student6.WorkoutHistory6;
import com.xpanxion.java.springboot.da1.demo.repository.student6.WorkoutHistoryRepository6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutHistoryService6 {

    @Autowired
    private WorkoutHistoryRepository6 workoutHistoryRepository6;

    public WorkoutHistory6 save(WorkoutHistory6 workoutHistory6) {
        return workoutHistoryRepository6.saveAndFlush(workoutHistory6);
    }
}
