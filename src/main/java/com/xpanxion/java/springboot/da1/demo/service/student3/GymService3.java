package com.xpanxion.java.springboot.da1.demo.service.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.*;
import com.xpanxion.java.springboot.da1.demo.repository.student3.CheckInOutRepository3;
import com.xpanxion.java.springboot.da1.demo.repository.student3.GymRepository3;
import com.xpanxion.java.springboot.da1.demo.repository.student3.MemberRepository3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class GymService3 {

    @Autowired
    private GymRepository3 gymRepository;

    @Autowired
    private MemberRepository3 memberRepository;

    @Autowired
    private CheckInOutRepository3 checkInOutRepository;

    final int MINUTES_SECONDS = 60 * 1000;

    //
    //Get
    //


    public List<Gym3> getGym(String name){
        return gymRepository.findByNameContaining(name);
    }

    public List<WorkoutHistoryPresentation> getWorkoutHistory(int memberId){
        try {
            Member3 member3 = memberRepository.findById(memberId).get();
            var checkInOutList = checkInOutRepository.findByMember3OrderByTime(member3);
            return checkInOutList.stream()
                    .map(c -> new WorkoutHistoryPresentation(c.getMember3().getMemberId(), c.getTime(), c.getCheckType())).toList();
        }catch (NoSuchElementException noSuchElementException){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member Id Not Found!");
        }

    }

    public WorkoutTime getWorkoutTime(int memberId, String type){
        List<WorkoutTime> workoutTimeList = new ArrayList<WorkoutTime>();

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        var l=  getWorkoutHistory(memberId); // sorted

        Date checkinTime = null;
        Date checkoutTime;
        String workoutDate;
        ParsePosition pp1 = new ParsePosition(0);

        for(WorkoutHistoryPresentation w : l){
            if (w.getCheckType3().equals(CheckType3.CHECKIN)){
                checkinTime = w.getTime();
            }else if (w.getCheckType3().equals(CheckType3.CHECKOUT)){
                checkoutTime = w.getTime();
                var deltaMs = checkoutTime.getTime() - checkinTime.getTime();
                var deltaMinutes = deltaMs / MINUTES_SECONDS;
                workoutDate = simpleDateFormat.format(w.getTime());
                workoutTimeList.add(new WorkoutTime(deltaMinutes, memberId, workoutDate));
            }
        }

        switch (type){
            case "min" -> {
                return workoutTimeList.get(0);
            }
            case "max" -> {
                Collections.sort(workoutTimeList);
                return workoutTimeList.get(0);
            }
            default -> throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Enter valid Type");
        }

        // Sort workoutTimeList by workout length
        // min is the first item, max is the last item to return
    }


    //
    //Post
    //

    public Gym3 addGym(Gym3 gym){
        return gymRepository.save(gym);
    }

    public Member3 addMember(Member3 member, int gymId) {
        Gym3 gym3 = gymRepository.findById(gymId).get();
        member.setGym(gym3);
        return memberRepository.save(member);
    }


    public CheckInOut3 addCheckIn(int memberId, Date time, CheckType3 checkType3){
        try {
            Member3 member = memberRepository.findById(memberId).get();
            CheckInOut3 checkInOut3 = new CheckInOut3(member, checkType3, time);
            return checkInOutRepository.save(checkInOut3);
        }catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member Id Not Found!");
        }
    }

    public CheckInOut3 addCheckOut(int memberId, Date time, CheckType3 checkType3){
        try{
            Member3 member = memberRepository.findById(memberId).get();
            CheckInOut3 checkInOut3 = new CheckInOut3(member, checkType3, time);
            return checkInOutRepository.save(checkInOut3);
        }catch (NoSuchElementException noSuchElementException){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member Id Not Found!");
        }
    }

    //
    //Put
    //

}
