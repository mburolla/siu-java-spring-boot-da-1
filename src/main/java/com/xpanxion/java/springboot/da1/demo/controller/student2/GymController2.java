package com.xpanxion.java.springboot.da1.demo.controller.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.Gym2;
import com.xpanxion.java.springboot.da1.demo.service.student2.GymService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GymController2 {

    @Autowired
    private GymService2 gymService2;

    @PostMapping("student2/api/v1/gym")
    public Gym2 addGym(@RequestBody Gym2 gym) {
        return gymService2.addGym(gym);
    }

}
