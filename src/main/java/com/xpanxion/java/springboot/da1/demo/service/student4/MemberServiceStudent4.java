package com.xpanxion.java.springboot.da1.demo.service.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Member4;
import com.xpanxion.java.springboot.da1.demo.model.student4.Workout4;
import com.xpanxion.java.springboot.da1.demo.repository.student4.MemberRepositoryStudent4;
import com.xpanxion.java.springboot.da1.demo.repository.student4.WorkoutRepository4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class MemberServiceStudent4 {

    @Autowired
    private MemberRepositoryStudent4 memberRepositoryStudent4;

    @Autowired
    private WorkoutRepository4 workoutRepository4;

    public Member4 addMember(Member4 member) {
        return memberRepositoryStudent4.save(member);
    }

    public Workout4 checkIn(int memberId, String timeIn) {

        if (memberRepositoryStudent4.findById(memberId) != null) {
            Workout4 workout = new Workout4(memberId, timeIn);
            return workoutRepository4.save(workout);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member ID not found");
        }

    }

    public Workout4 checkOut(int memberId, String timeOut) {
        if(memberRepositoryStudent4.findById(memberId)!=null){
            var memberWorkout = workoutRepository4.findTopByMemberId(memberId);
            if (memberWorkout.getTimeOut() == null) {
                memberWorkout.setTimeOut(timeOut);
            }
            workoutRepository4.save(memberWorkout);
            return memberWorkout;
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member ID not found");
        }

    }
}
