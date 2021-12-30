package com.xpanxion.java.springboot.da1.demo.controller.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Gym8;
import com.xpanxion.java.springboot.da1.demo.service.student8.GymService8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GymController8 {

    @Autowired
    private GymService8 gymService8;

    @GetMapping("student8/api/v1/gym") // ?name={value}
    public List<Gym8> findGym(@RequestParam String name) {
        var gyms = gymService8.findGym(name);
        return gyms;
    }

    @PostMapping("student8/api/v1/gym")
    public void createGym(@RequestBody Gym8 gym) {
        gymService8.createGym(gym);
    }

}
