package com.xpanxion.java.springboot.da1.demo.controller.student4;


import com.xpanxion.java.springboot.da1.demo.model.student4.Gym;
import com.xpanxion.java.springboot.da1.demo.service.student4.GymServiceStudent4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GymController4 {

        //
        // Data members
        //

        @Autowired
        private GymServiceStudent4 gymServiceStudent4;

        @PostMapping("student4/api/v1/gym")
        private Gym addGym(@RequestBody Gym gym){
            return gymServiceStudent4.addGym(gym);
        }
}
