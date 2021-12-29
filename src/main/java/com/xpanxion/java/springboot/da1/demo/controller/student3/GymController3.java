package com.xpanxion.java.springboot.da1.demo.controller.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.Gym3;
import com.xpanxion.java.springboot.da1.demo.service.student3.GymService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GymController3 {

    @Autowired
    GymService3 gymService3;

    @PostMapping("student3/api/v1/gym")
    public Gym3 addGym(@RequestBody Gym3 gym){
        return gymService3.addGym(gym);
    }
}
