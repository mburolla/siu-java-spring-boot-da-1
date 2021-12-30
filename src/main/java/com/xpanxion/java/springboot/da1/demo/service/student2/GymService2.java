package com.xpanxion.java.springboot.da1.demo.service.student2;

import com.xpanxion.java.springboot.da1.demo.repository.student2.GymRepository2;
import com.xpanxion.java.springboot.da1.demo.model.student2.Gym2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class GymService2 {

    @Autowired
    private GymRepository2 gymRepository2;

    public Gym2 addGym(Gym2 gym) {
        return gymRepository2.save(gym);
    }

    public List<Gym2> getGymNames(String name) {
        return gymRepository2.findByNameContaining(name);
    }

}
