package com.xpanxion.java.springboot.da1.demo.controller.student6;

import com.xpanxion.java.springboot.da1.demo.model.student6.Gym;
import com.xpanxion.java.springboot.da1.demo.service.student6.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GymController {

    @Autowired
    GymService gymService;

    @GetMapping("student6/api/v1/gym{id}")
    public ResponseEntity<Gym> getGymById(@PathVariable int id) throws Exception {
        Gym gym = gymService.findById(id);
        return ResponseEntity.ok(gym);
    }

    @PostMapping("student6/api/v1/gym")
    public Gym update(@RequestBody Gym gym) {
        return gymService.post(gym);
    }
}
