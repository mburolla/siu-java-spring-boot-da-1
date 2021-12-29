package com.xpanxion.java.springboot.da1.demo.service.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Gym;
import com.xpanxion.java.springboot.da1.demo.repository.student8.GymRepository8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymService8 {

    // DATA

    @Autowired
    private GymRepository8 gymRepository8;

    // CONSTRUCTOR

    public void GymService8() {}

    // METHODS

    public Gym createGym(Gym gym) {
        return gymRepository8.save(gym);
    }
}
