package com.xpanxion.java.springboot.da1.demo.service.student2;

import com.xpanxion.java.springboot.da1.demo.repository.student2.GymRepository2;
import com.xpanxion.java.springboot.da1.demo.model.student2.Gym;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymService2 {

    @Autowired
    private GymRepository2 gymRepository2;

    public Gym addGym(Gym gym) {
        return gymRepository2.save(gym);
    }


}
