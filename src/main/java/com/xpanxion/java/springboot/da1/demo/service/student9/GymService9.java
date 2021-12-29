package com.xpanxion.java.springboot.da1.demo.service.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Gym9;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.GymRepository9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class GymService9 {
    //Data members

    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    private GymRepository9 gymRepository9;


    //Methods
    public Gym9 addGym(Gym9 gym){
        return gymRepository9.save(gym);
    }
}
