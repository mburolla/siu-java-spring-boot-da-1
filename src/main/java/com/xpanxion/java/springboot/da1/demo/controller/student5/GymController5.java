package com.xpanxion.java.springboot.da1.demo.controller.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.Gym5;
import com.xpanxion.java.springboot.da1.demo.service.student5.GymService5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GymController5 {

    @Autowired
    private GymService5 gymService;

    //GET
    @GetMapping("student5/api/v1/gym")
    public List<Gym5> findAllByNameContaining(@RequestParam("name") String name) {
        return gymService.findAllByNameContaining(name);
    }
    //POST
    @PostMapping("student5/api/v1/gym")
    public Gym5 addGym(@RequestBody Gym5 gym) {
        return gymService.addGym(gym);
    }
}
