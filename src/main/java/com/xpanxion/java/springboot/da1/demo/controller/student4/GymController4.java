package com.xpanxion.java.springboot.da1.demo.controller.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Gym4;
import com.xpanxion.java.springboot.da1.demo.service.student4.GymServiceStudent4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GymController4 {

        //
        // Data members
        //

        @Autowired
        private GymServiceStudent4 gymServiceStudent4;

        @PostMapping("student4/api/v1/gym")
        private Gym4 addGym(@RequestBody Gym4 gym){
            return gymServiceStudent4.addGym(gym);
        }

        @GetMapping("student{id}/api/v1/gym?name=Gold")
        private List<Gym4> getFindByNameContaining(@RequestParam String name){
                return gymServiceStudent4.getFindByNameContaining(name);
        }
}
