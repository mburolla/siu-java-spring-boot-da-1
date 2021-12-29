package com.xpanxion.java.springboot.da1.demo.controller.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.Gym;
import com.xpanxion.java.springboot.da1.demo.service.student10.GymService10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GymController10 {

    @Autowired
    private GymService10 gymService;

    @PostMapping("student10/api/v1/gym")
    public Gym addGym(@RequestBody Gym gym) {
        return gymService.addGym(gym);
    }

}
