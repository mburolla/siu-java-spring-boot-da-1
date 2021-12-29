package com.xpanxion.java.springboot.da1.demo.controller.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Gym;
import com.xpanxion.java.springboot.da1.demo.service.student9.GymService9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GymController {

    //Data members
    @Autowired
    private GymService9 gymService9;

    @PostMapping("student9/api/v1/gym")
    public Gym addGym(@RequestBody Gym gym){
        return gymService9.addGym(gym);
    }
}
