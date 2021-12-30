package com.xpanxion.java.springboot.da1.demo.service.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Gym1;
import com.xpanxion.java.springboot.da1.demo.model.student1.GymMember1;
import com.xpanxion.java.springboot.da1.demo.repository.student1.GymMemberRepository1;
import com.xpanxion.java.springboot.da1.demo.repository.student1.GymRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService1 {

    @Autowired
    private GymRepository1 gymRepository1;

    @Autowired
    private GymMemberRepository1 gymMemberRepository1;

    public void addGym(Gym1 gym) {

        gymRepository1.save(gym);

    }

    public List<Gym1> findGym(String name) {

        return gymRepository1.findByNameContaining(name);

    }

    public void addGymMember(int gymId, GymMember1 gymMember1) {

        Gym1 gym = gymRepository1.findById(gymId);
        if (gym != null) {

            gymMemberRepository1.save(gymMember1);

        }

    }

}
