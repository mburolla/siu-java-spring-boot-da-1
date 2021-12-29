package com.xpanxion.java.springboot.da1.demo.controller.student6.service;

import com.xpanxion.java.springboot.da1.demo.controller.student6.model.Gym;
import com.xpanxion.java.springboot.da1.demo.controller.student6.repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymService {

    @Autowired
    private GymRepository gymRepository;

    public Gym post(Gym gym) {
        return gymRepository.saveAndFlush(gym);
    }

}
