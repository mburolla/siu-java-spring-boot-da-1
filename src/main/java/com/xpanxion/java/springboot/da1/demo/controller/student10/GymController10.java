package com.xpanxion.java.springboot.da1.demo.controller.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.Gym10;
import com.xpanxion.java.springboot.da1.demo.model.student10.GymMember10;
import com.xpanxion.java.springboot.da1.demo.service.student10.GymMemberService10;
import com.xpanxion.java.springboot.da1.demo.service.student10.GymService10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GymController10 {

    @Autowired
    private GymService10 gymService;

    @PostMapping("student10/api/v1/gym")
    public Gym10 addGym(@RequestBody Gym10 gym) {
        return gymService.addGym(gym);
    }

    @GetMapping("student10/api/v1/gym") // student10/api/v1/gym?name=gold
    public List<Gym10> getGym(@RequestParam String name){
        return gymService.findByNameContaining(name);
    }
}
