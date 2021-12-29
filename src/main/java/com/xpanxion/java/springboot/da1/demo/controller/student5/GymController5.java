package com.xpanxion.java.springboot.da1.demo.controller.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.Gym;
import com.xpanxion.java.springboot.da1.demo.service.student5.GymService5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GymController5 {

    @Autowired
    private GymService5 gymService5;

//    //GET
//    public List<Gym> getGymWithSimilarName(String name) {
//        List<Gym> gyms;
//
//        gyms = gymService5.getGymWithSimilarName(name);
//
//        return gyms;
//    }
    //POST
    @PostMapping("student5/api/v1/gym")
    public Gym addGym(@RequestBody Gym gym) {
        return gymService5.addGym(gym);
    }
}
