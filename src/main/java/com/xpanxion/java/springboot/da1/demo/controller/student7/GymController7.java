package com.xpanxion.java.springboot.da1.demo.controller.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.Gym;
import com.xpanxion.java.springboot.da1.demo.service.student7.GymService7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GymController7 {

    @Autowired
    GymService7 gymService;

    @PostMapping("student7/api/v1/gym")
    public Gym addGym(@RequestBody Gym gym) {
        return gymService.addGym(gym);
    }
}
