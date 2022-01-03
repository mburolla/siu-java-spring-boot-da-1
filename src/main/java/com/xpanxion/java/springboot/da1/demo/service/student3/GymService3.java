package com.xpanxion.java.springboot.da1.demo.service.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.CheckInOut3;
import com.xpanxion.java.springboot.da1.demo.model.student3.CheckType3;
import com.xpanxion.java.springboot.da1.demo.model.student3.Gym3;
import com.xpanxion.java.springboot.da1.demo.model.student3.Member3;
import com.xpanxion.java.springboot.da1.demo.repository.student3.CheckInOutRepository3;
import com.xpanxion.java.springboot.da1.demo.repository.student3.GymRepository3;
import com.xpanxion.java.springboot.da1.demo.repository.student3.MemberRepository3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public List<CheckInOut3> getWorkoutHistory(int memberId){
        Member3 member3 = memberRepository.findById(memberId).get();
        return checkInOutRepository.findByMember3(member3);
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
