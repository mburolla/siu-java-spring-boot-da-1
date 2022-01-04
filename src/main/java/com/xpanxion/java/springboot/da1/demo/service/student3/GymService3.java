package com.xpanxion.java.springboot.da1.demo.service.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.*;
import com.xpanxion.java.springboot.da1.demo.repository.student3.CheckInOutRepository3;
import com.xpanxion.java.springboot.da1.demo.repository.student3.GymRepository3;
import com.xpanxion.java.springboot.da1.demo.repository.student3.MemberRepository3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GymService3 {

    @Autowired
    private GymRepository3 gymRepository;

    @Autowired
    private MemberRepository3 memberRepository;

    @Autowired
    private CheckInOutRepository3 checkInOutRepository;

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

    public List<WorkoutTime> getWorkoutTime(int memberId){
        var l=  getWorkoutHistory(memberId); // sorted


        for(WorkoutHistoryPresentation w : l){
            // do stuff here
        }
//        Member3 member3 = memberRepository.findById(memberId).get();
//        var checkInOutList = checkInOutRepository.findByMember3(member3);
//        checkInOutList.stream().map(c -> new WorkoutTime(c.getMember3().getMemberId(), c.getTime()));
        return null;
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


    public CheckInOut3 addCheckIn(int memberId, String time, CheckType3 checkType3){
        try {
            Member3 member = memberRepository.findById(memberId).get();
            CheckInOut3 checkInOut3 = new CheckInOut3(member, checkType3, time);
            return checkInOutRepository.save(checkInOut3);
        }catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member Id Not Found!");
        }
    }

    public CheckInOut3 addCheckOut(int memberId, String time, CheckType3 checkType3){
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
