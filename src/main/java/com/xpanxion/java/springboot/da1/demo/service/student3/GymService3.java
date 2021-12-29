package com.xpanxion.java.springboot.da1.demo.service.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.Gym3;
import com.xpanxion.java.springboot.da1.demo.repository.student3.GymRepository3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymService3 {

    @Autowired
    private GymRepository3 gymRepository;

    public Gym3 addGym(Gym3 gym){
        return gymRepository.save(gym);
    }
}
