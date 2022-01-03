package com.xpanxion.java.springboot.da1.demo.service.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.GymMember10;
import com.xpanxion.java.springboot.da1.demo.model.student10.Workout10;
import com.xpanxion.java.springboot.da1.demo.repository.student10.GymMemberRepository10;
import com.xpanxion.java.springboot.da1.demo.repository.student10.GymRepository10;
import com.xpanxion.java.springboot.da1.demo.repository.student10.WorkoutRepository10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GymMemberService10 {

    @Autowired
    private GymRepository10 gymRepository;
    @Autowired
    private GymMemberRepository10 memberRepository;
    @Autowired
    private WorkoutRepository10 workoutRepository;

    public GymMember10 addMember(int gymId, GymMember10 member){
        member.setGym(gymRepository.findById(gymId));
        return memberRepository.save(member);
    }

    public Workout10 checkIn(int memberId, String timeIn) {
        if(memberRepository.findById(memberId)!=null) {
            Workout10 workout = new Workout10(memberId, timeIn);
            return workoutRepository.save(workout);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member ID not found");
        }
    }

    public Workout10 checkOut(int memberId, String timeOut) {
        if(memberRepository.findById(memberId)!=null){
            var memberWorkout = workoutRepository.findTopByMemberIdOrderByWorkoutIdDesc(memberId);
            if (memberWorkout.getTimeOut() == null) {
                memberWorkout.setTimeOut(timeOut);
            }
            workoutRepository.save(memberWorkout);
            return memberWorkout;
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member ID not found");
        }

    }
}
