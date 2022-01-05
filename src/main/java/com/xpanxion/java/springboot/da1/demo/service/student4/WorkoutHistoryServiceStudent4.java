package com.xpanxion.java.springboot.da1.demo.service.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Workout4;
import com.xpanxion.java.springboot.da1.demo.repository.student4.WorkoutHistoryRepository4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
public class WorkoutHistoryServiceStudent4 {

        @Autowired
        private WorkoutHistoryRepository4 workoutHistoryRepository;
        @Autowired
        private MemberServiceStudent4 memberService;

        public Workout4 workoutCheckIn(Long memberId, Date time) {
                var member = memberService.getMember(memberId);
                return workoutHistoryRepository.save(new Workout4(member, time));
        }

        public Workout4 workoutCheckOut(Long memberId, Date time) {
                var workoutList = workoutHistoryRepository.findAllByMemberMemberIdOrderByWorkoutIdDesc(memberId);
                if (workoutList.isEmpty())
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member id not found");
                else if (workoutList.get(0).getCheckOut() != null)
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not currently checked in");
                var workout = workoutList.get(0);
                workout.setCheckOut(time);
                workoutHistoryRepository.save(workout);
                return workout;
        }
}
