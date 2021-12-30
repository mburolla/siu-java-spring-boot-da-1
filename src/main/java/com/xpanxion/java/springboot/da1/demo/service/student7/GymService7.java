package com.xpanxion.java.springboot.da1.demo.service.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.Gym7;
import com.xpanxion.java.springboot.da1.demo.repository.student7.GymRepository7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class GymService7 {
    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    private GymRepository7 gymRepository;

    public Gym7 addGym(Gym7 gym) {
        return gymRepository.save(gym);

    }

    public List<Gym7> findGym(String name) {
        return gymRepository.findByNameContaining(name);
    }
}
