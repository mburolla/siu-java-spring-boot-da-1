package com.xpanxion.java.springboot.da1.demo.service.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.Gym7;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.student7.GymRepository7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class GymService7 {
    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    private GymRepository7 gymRepository;

    public Gym7 addGym(Gym7 gym) {
        return gymRepository.save(gym);

    }
}
