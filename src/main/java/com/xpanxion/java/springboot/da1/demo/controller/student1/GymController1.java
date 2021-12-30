package com.xpanxion.java.springboot.da1.demo.controller.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Gym1;
import com.xpanxion.java.springboot.da1.demo.model.student1.GymMember1;
import com.xpanxion.java.springboot.da1.demo.service.student1.GymService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("student1/api/v1/gym1")
@RestController
public class GymController1 {

    @Autowired
    GymService1 gymService1;

    @GetMapping
    public List<Gym1> findGym(@RequestParam String name) {

        return gymService1.findGym(name);

    }

    @PostMapping
    public void addGym(@RequestBody Gym1 gym) {

        gymService1.addGym(gym);

    }

    @PostMapping(path = "{gymId}/member")
    public void addMember(@PathVariable("gymId") int gymId, @RequestBody GymMember1 gymMember) {

        gymService1.addGymMember(gymId, gymMember);

    }

}
