package com.xpanxion.java.springboot.da1.demo.controller.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Gym;
import com.xpanxion.java.springboot.da1.demo.service.student8.GymService8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GymController8 {

    @Autowired
    private GymService8 gymService8;

    @PostMapping("student8/api/v1/gym")
    public void createGym(@RequestBody Gym gym) {
        gymService8.createGym(gym);
    }

}
