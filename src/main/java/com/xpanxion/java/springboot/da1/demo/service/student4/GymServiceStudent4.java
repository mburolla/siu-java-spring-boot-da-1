package com.xpanxion.java.springboot.da1.demo.service.student4;


import com.xpanxion.java.springboot.da1.demo.model.student4.Gym;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.GymRepositoryStudent4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class GymServiceStudent4 {
    //Data members

    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    private GymRepositoryStudent4 gymRepositoryStudent4;

    //Methods
    public Gym addGym(Gym gym){
        return gymRepositoryStudent4.save(gym);
    }
}
