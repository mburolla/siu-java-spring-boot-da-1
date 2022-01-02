package com.xpanxion.java.springboot.da1.demo.controller.instructor;

import com.xpanxion.java.springboot.da1.demo.model.instructor.Gym0;
import com.xpanxion.java.springboot.da1.demo.service.instructor.GymService0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GymController0 {

    @Autowired
    private GymService0 gymService0;

    @PostMapping("instructor/api/v1/gym")
    public Gym0 addGym(@RequestBody Gym0 gym) {
        gym.setId(gymService0.addGym(gym));
        return gym;
    }
}
