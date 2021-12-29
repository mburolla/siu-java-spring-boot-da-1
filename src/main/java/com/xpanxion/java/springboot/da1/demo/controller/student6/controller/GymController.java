package com.xpanxion.java.springboot.da1.demo.controller.student6.controller;

import com.xpanxion.java.springboot.da1.demo.controller.student6.model.Gym;
import com.xpanxion.java.springboot.da1.demo.controller.student6.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class GymController {

    @Autowired
    private GymService gymService;

    @PostMapping("student6/api/v1/gym")
    public Gym postGym(@RequestBody Gym gym) {
        return gymService.post(gym);
    }
}
