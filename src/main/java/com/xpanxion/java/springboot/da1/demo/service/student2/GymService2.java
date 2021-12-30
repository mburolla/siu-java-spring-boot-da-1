package com.xpanxion.java.springboot.da1.demo.service.student2;

import com.xpanxion.java.springboot.da1.demo.repository.student2.GymRepository2;
import com.xpanxion.java.springboot.da1.demo.model.student2.Gym2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService2 {

    @Autowired
    private GymRepository2 gymRepository2;

    public List<Gym2> getGymNames(String name) {
        return gymRepository2.findByNameContaining(name);
    }

    public Gym2 addGym(Gym2 gym) {
        return gymRepository2.save(gym);
    }
}
