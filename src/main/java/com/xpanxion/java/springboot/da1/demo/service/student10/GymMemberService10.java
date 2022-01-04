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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    public Workout10 checkIn(int memberId, String timeStamp) throws ParseException {
        if(memberRepository.findById(memberId)!=null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date time = formatter.parse(timeStamp);
            Workout10 workout = new Workout10(memberId, time, "CHECK_IN");
            return workoutRepository.save(workout);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member ID not found");
        }
    }

    public Workout10 checkOut(int memberId, String timeStamp) throws ParseException {
        if(memberRepository.findById(memberId)!=null){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date time = formatter.parse(timeStamp);
            Workout10 workout = new Workout10(memberId, time, "CHECK_OUT");
            return workoutRepository.save(workout);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member ID not found");
        }

    }

    public List<Workout10> getWorkoutHistory(int memberId) {
        if(memberRepository.findById(memberId)!=null) {
            var workoutList = workoutRepository.findAllByMemberId(memberId);
            return workoutList;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member ID not found");
        }
    }
}
