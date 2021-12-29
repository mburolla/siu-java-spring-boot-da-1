package com.xpanxion.java.springboot.da1.demo.service.student6;

import com.xpanxion.java.springboot.da1.demo.model.student6.Gym;
import com.xpanxion.java.springboot.da1.demo.repository.student6.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {


    @Autowired
    private GymRepository gymRepository;

    public List<Gym> findAll() {
        return gymRepository.findAll();
    }

    public Gym post(Gym gym) {
        return gymRepository.saveAndFlush(gym);
    }

    public Gym findById(int id) throws Exception {
        return gymRepository.findById(id)
                .orElseThrow(() -> new Exception("Gym not found with id"));
    }
}
