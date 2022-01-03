package com.xpanxion.java.springboot.da1.demo.service.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.WorkoutHistory5;
import com.xpanxion.java.springboot.da1.demo.repository.student5.WorkoutHistoryRepository5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class WorkoutHistoryService5 {

    @Autowired
    private WorkoutHistoryRepository5 workoutHistoryRepository;

    public WorkoutHistory5 workoutCheckIn(Long memberId, Date time) {
        return workoutHistoryRepository.save(new WorkoutHistory5(memberId, time));
    }

    public WorkoutHistory5 workoutCheckOut(Long memberId, Date time) throws ParseException {
        var workout = workoutHistoryRepository.findAllByMemberIdOrderByWorkoutIdDesc(memberId)
                .stream()
                .toList()
                .get(0);
        workout.setCheckOut(time);
        workoutHistoryRepository.save(workout);
        return workout;
    }
}
