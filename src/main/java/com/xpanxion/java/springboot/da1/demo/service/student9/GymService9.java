package com.xpanxion.java.springboot.da1.demo.service.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Gym9;
import com.xpanxion.java.springboot.da1.demo.repository.student9.GymRepository9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    public List<Gym9> getFindByNameContaining(String name){
        return gymRepository9.findByNameContaining(name);
    }

}
