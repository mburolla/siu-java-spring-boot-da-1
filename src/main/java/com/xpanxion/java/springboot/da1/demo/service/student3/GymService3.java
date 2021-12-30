package com.xpanxion.java.springboot.da1.demo.service.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.CheckInOut3;
import com.xpanxion.java.springboot.da1.demo.model.student3.Gym3;
import com.xpanxion.java.springboot.da1.demo.model.student3.Member3;
import com.xpanxion.java.springboot.da1.demo.repository.student3.CheckInOutRepository3;
import com.xpanxion.java.springboot.da1.demo.repository.student3.GymRepository3;
import com.xpanxion.java.springboot.da1.demo.repository.student3.MemberRepository3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GymService3 {

    @Autowired
    private GymRepository3 gymRepository;

    @Autowired
    private MemberRepository3 memberRepository;

    @Autowired
    private CheckInOutRepository3 checkInOutRepository;

    public Gym3 addGym(Gym3 gym){
        return gymRepository.save(gym);
    }

    public List<Gym3> getGym(String name){
        return gymRepository.findByNameContaining(name);
    }

    public Member3 addMember(Member3 member) {return memberRepository.save(member);}

    public CheckInOut3 addCheckIn(CheckInOut3 checkInOut3){
        return checkInOutRepository.save(checkInOut3);
    }

//    public CheckInOut3 addCheckOut(CheckInOut3 checkInOut3){
//        return checkInOutRepository.save(checkInOut3);
//    }
}
