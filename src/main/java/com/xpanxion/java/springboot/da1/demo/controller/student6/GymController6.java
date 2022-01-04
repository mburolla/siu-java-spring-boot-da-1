package com.xpanxion.java.springboot.da1.demo.controller.student6;

import com.xpanxion.java.springboot.da1.demo.model.student6.Gym6;
import com.xpanxion.java.springboot.da1.demo.service.student6.GymService6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GymController6 {

    @Autowired
    GymService6 gymService6;

    @GetMapping("student6/api/v1/gym6?name={name}")
    public List<Gym6> getGymByName(@PathVariable String name){
        List<Gym6> gym6 = gymService6.findByName(name);
        return gym6;
    }


    @PostMapping("student6/api/v1/gym6")
    public Gym6 update(@RequestBody Gym6 gym6) {
        return gymService6.post(gym6);
    }
}
