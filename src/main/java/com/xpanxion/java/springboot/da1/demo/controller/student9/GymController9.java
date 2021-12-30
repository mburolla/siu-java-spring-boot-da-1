package com.xpanxion.java.springboot.da1.demo.controller.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Gym9;
import com.xpanxion.java.springboot.da1.demo.service.student9.GymService9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GymController9 {

    //Data members
    @Autowired
    private GymService9 gymService9;

    @PostMapping("student9/api/v1/gym")
    public Gym9 addGym(@RequestBody Gym9 gym){
        return gymService9.addGym(gym);
    }

    @GetMapping("student9/api/v1/gym") // ?name=value - not needed
    public List<Gym9> getFindByNameContaining(@RequestParam String name){
        return gymService9.getFindByNameContaining(name);
    }
}
