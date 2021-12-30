package com.xpanxion.java.springboot.da1.demo.controller.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.Gym7;
import com.xpanxion.java.springboot.da1.demo.service.student7.GymService7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GymController7 {

    @Autowired
    GymService7 gymService;

    @PostMapping("student7/api/v1/gym")
    public Gym7 addGym(@RequestBody Gym7 gym) {
        return gymService.addGym(gym);
    }

    @GetMapping("student7/api/v1/gym") //?name={partialGymName}
    public List<Gym7> findGym(@RequestParam String name) {
        return gymService.findGym(name);
    }
}
