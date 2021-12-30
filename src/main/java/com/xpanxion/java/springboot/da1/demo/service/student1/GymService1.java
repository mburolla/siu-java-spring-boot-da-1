package com.xpanxion.java.springboot.da1.demo.service.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Gym1;
import com.xpanxion.java.springboot.da1.demo.model.student1.GymMember1;
import com.xpanxion.java.springboot.da1.demo.repository.student1.GymMemberRepository1;
import com.xpanxion.java.springboot.da1.demo.repository.student1.GymRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

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

    public AtomicReference<String> addGymMember(int gymId, GymMember1 gymMember1) {

        AtomicReference<String> result = new AtomicReference<>("Gym Added!");

        gymMember1.setGymId(gymId);
        Optional<Gym1> gym = gymRepository1.findById(gymId);
        gym.ifPresentOrElse(
                gym1 -> gymMemberRepository1.save(gymMember1),
                () -> result.set("Gym not found!")
                );

        return result;
    }

}
