package com.xpanxion.java.springboot.da1.demo.service.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Gym;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.student1.GymRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymService1 {

    @Autowired
    private GymRepository1 gymRepository1;

    public void addGym(Gym gym) {

        gymRepository1.save(gym);

    }

}
