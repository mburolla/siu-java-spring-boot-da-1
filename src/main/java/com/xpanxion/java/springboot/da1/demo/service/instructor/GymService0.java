package com.xpanxion.java.springboot.da1.demo.service.instructor;

import com.xpanxion.java.springboot.da1.demo.model.instructor.Gym0;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.GymRepository0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymService0 {

    @Autowired
    private GymRepository0 gymRepository0;

    public int addGym(Gym0 gym) {
        return gymRepository0.save(gym).getGymId();
    }

//    public GymRepository0 addMember(int gymId, GymMember10 member){
//        member.setGym(gymRepository.findById(gymId));
//        return memberRepository.save(member);
//    }
}
