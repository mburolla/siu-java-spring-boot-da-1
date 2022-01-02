package com.xpanxion.java.springboot.da1.demo.service.instructor;

import com.xpanxion.java.springboot.da1.demo.controller.instructor.WorkoutHistory;
import com.xpanxion.java.springboot.da1.demo.model.instructor.CheckType;
import com.xpanxion.java.springboot.da1.demo.model.instructor.Member0;
import com.xpanxion.java.springboot.da1.demo.model.instructor.WorkoutHistory0;
import com.xpanxion.java.springboot.da1.demo.model.instructor.response.WorkoutTime;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.GymRepository0;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.MemberRepository0;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.WorkoutHistoryRepository0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class MemberService0 {

    @Autowired
    private GymRepository0 gymRepository0;

    @Autowired
    private MemberRepository0 memberRepository0;

    @Autowired
    private WorkoutHistoryRepository0 workoutHistoryRepository0;

    public int addMemberToGymId(Member0 member0, int gymId) {
        member0.setGym(gymRepository0.findById(gymId).get());
        return memberRepository0.save(member0).getMemberId();
    }

    public void checkMember(CheckType checkType, int memberId, Date time) {
        var member = memberRepository0.findById(memberId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found."));
        var workoutHistory = new WorkoutHistory0(member, time, checkType);
        workoutHistoryRepository0.save(workoutHistory);
    }

    public List<WorkoutTime> getWorkoutHistory(int memberId) {
        var workoutHistory = workoutHistoryRepository0.getWorkoutHistoryForMember(memberId);
        var member = memberRepository0.findById(memberId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found."));
        return workoutHistory.stream().map(w -> new WorkoutTime(member.getMemberId(),w.getTime(),w.getCheckType())).toList();
    }
}
