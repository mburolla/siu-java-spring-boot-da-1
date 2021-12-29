package com.xpanxion.java.springboot.da1.demo.service.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.Gym;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.student10.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class GymService10 {

    //Data Members
    @PersistenceContext
    public EntityManager entityManager;
    @Autowired
    private GymRepository gymRepository;

    //Methods
    public Gym addGym(Gym gym) {
        return gymRepository.save(gym);
    }


}
