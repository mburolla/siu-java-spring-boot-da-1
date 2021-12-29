package com.xpanxion.java.springboot.da1.demo.service.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.Gym;
import com.xpanxion.java.springboot.da1.demo.repository.student5.GymRepository5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService5 {

    @Autowired
    private GymRepository5 gymRepository;

    public Gym addGym(Gym gym) {
        return gymRepository.save(gym);
    }
}
