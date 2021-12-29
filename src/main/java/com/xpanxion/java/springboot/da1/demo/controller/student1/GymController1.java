package com.xpanxion.java.springboot.da1.demo.controller.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Gym;
import com.xpanxion.java.springboot.da1.demo.service.student1.GymService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GymController1 {

    @Autowired
    GymService1 gymService1;

    @PostMapping("student1/api/v1/gym")
    public void addGym(@RequestBody Gym gym) {

        gymService1.addGym(gym);

    }

}
