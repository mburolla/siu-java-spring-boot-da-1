package com.xpanxion.java.springboot.da1.demo.service.student6;

import com.xpanxion.java.springboot.da1.demo.model.student6.Gym6;
import com.xpanxion.java.springboot.da1.demo.repository.student6.GymRepository6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService6 {

    @Autowired
    private GymRepository6 gymRepository6;

    public List<Gym6> findAll() {
        return gymRepository6.findAll();
    }

    public Gym6 post(Gym6 gym6) {
        return gymRepository6.saveAndFlush(gym6);
    }

    public List<Gym6> findByName(String name) {
        return gymRepository6.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
