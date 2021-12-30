package com.xpanxion.java.springboot.da1.demo.service.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Gym4;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.GymRepositoryStudent4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class GymServiceStudent4 {
    //Data members

    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    private GymRepositoryStudent4 gymRepositoryStudent4;

    //Methods
    public Gym4 addGym(Gym4 gym) {
        return gymRepositoryStudent4.save(gym);
    }

    public List<Gym4> getFindByName(String name) {
        return gymRepositoryStudent4.findByNameContaining(name);
    }
}

