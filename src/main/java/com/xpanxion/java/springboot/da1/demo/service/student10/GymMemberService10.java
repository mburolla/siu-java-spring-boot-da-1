package com.xpanxion.java.springboot.da1.demo.service.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.GymMember10;
import com.xpanxion.java.springboot.da1.demo.model.student10.Workout10;
import com.xpanxion.java.springboot.da1.demo.model.student10.WorkoutTimes10;
import com.xpanxion.java.springboot.da1.demo.repository.student10.GymMemberRepository10;
import com.xpanxion.java.springboot.da1.demo.repository.student10.GymRepository10;
import com.xpanxion.java.springboot.da1.demo.repository.student10.WorkoutRepository10;
import com.xpanxion.java.springboot.da1.demo.repository.student10.WorkoutTimesRepository10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class GymMemberService10 {

    @Autowired
    private GymRepository10 gymRepository;
    @Autowired
    private GymMemberRepository10 memberRepository;
    @Autowired
    private WorkoutRepository10 workoutRepository;
    @Autowired
    private WorkoutTimesRepository10 timesRepository;

    public GymMember10 addMember(int gymId, GymMember10 member){
        member.setGym(gymRepository.findById(gymId));
        return memberRepository.save(member);
    }

    public Workout10 checkIn(int memberId, String timeStamp) throws ParseException {
        if(memberRepository.findById(memberId)!=null) {
            SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
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
            //Find most recent Checkin
            var checkIn = workoutRepository.findTopByMemberIdOrderByWorkoutIdDesc(memberId);
            var checkInTime = checkIn.getTimeStamp();
            //Create Checkout
            SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
            Date checkOutTime = formatter.parse(timeStamp);
            Workout10 workout = new Workout10(memberId, checkOutTime, "CHECK_OUT");
            //Calculate total workout time
            long totalTime = checkOutTime.getTime() - checkInTime.getTime(); //in milliseconds
            TimeUnit unit = TimeUnit.MINUTES;
            long newTotalTime = unit.convert(totalTime, TimeUnit.MILLISECONDS);
            //Create workout time object and add to database
            SimpleDateFormat formatter2 = new SimpleDateFormat("MM-dd-yyyy");
            Date workoutDate = formatter2.parse(timeStamp);
            WorkoutTimes10 workoutTime = new WorkoutTimes10(newTotalTime, memberId, workoutDate);
            timesRepository.save(workoutTime);
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

    public WorkoutTimes10 getWorkoutTimes(int memberId, String type) {
        if(memberRepository.findById(memberId)!=null) {
            List<WorkoutTimes10> times = timesRepository.findAllByMemberId(memberId);
            if (type.equals("min")) {
                Collections.sort(times);
                return times.get(0);
            }
            else {
                Collections.sort(times, Collections.reverseOrder());
                return times.get(0);
            }
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member ID not found");
        }
    }
}
