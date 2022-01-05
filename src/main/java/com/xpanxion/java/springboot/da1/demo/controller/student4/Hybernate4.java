package com.xpanxion.java.springboot.da1.demo.controller.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Gym4;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.GymRepositoryStudent4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class Hybernate4 {
    @Service
    @Transactional // <============ Hibernate
    public class GymService0 {

        @Autowired
        private GymRepositoryStudent4 gymRepository;

        @PersistenceContext // <============ Hibernate
        public EntityManager entityManager; // <============ Hibernate

        public Gym4 addGym(Gym4 gym) {

            ////////////////////////////////////////////////
            // Spring Data JPA
            ///////////////////////////////////////////////
            //return gymRepository0.save(gym);

            ////////////////////////////////////////////////
            // Hibernate
            ///////////////////////////////////////////////


        // gym model is in the transient state.
        entityManager.persist(gym);
        // gym is in the managed (persisted) state.
        gym.setName("World Gym");  // Marty's Gym 2

        return gym;


//            var aGym = entityManager.find(Gym4.class, 78);
//            //aGym is in the managed (persisted) state.
//            aGym.setName("Hibernate update");
        }
    }
}

