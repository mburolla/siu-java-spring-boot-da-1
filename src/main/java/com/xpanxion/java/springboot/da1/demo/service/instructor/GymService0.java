package com.xpanxion.java.springboot.da1.demo.service.instructor;

import com.xpanxion.java.springboot.da1.demo.model.instructor.Gym0;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.GymRepository0;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional // <============ Hibernate
public class GymService0 {

    @Autowired
    private GymRepository0 gymRepository0;

    @PersistenceContext // <============ Hibernate
    public EntityManager entityManager; // <============ Hibernate

    public Gym0 addGym(Gym0 gym) {

        ////////////////////////////////////////////////
        // Spring Data JPA
        ///////////////////////////////////////////////
        return gymRepository0.save(gym);

        ////////////////////////////////////////////////
        // Hibernate
        ///////////////////////////////////////////////
        /*
        // gym model is in the transient state.
        entityManager.persist(gym);
        // gym is in the managed (persisted) state.
        gym.setName("World Gym");
        return gym;
        */

        /*
        var aGym = entityManager.find(Gym0.class, 73);
        //aGym is in the managed (persisted) state.
        aGym.setName("Hibernate update2");

        entityManager.detach(aGym);
        // aGym is in the detached stated
        aGym.setName("Not gonna save me.");

        entityManager.merge(aGym); // Saves to db, but still detached.
        aGym.setName("does not work");

        // Session session = entityManager.unwrap(Session.class);
        // session.update(aGym);

        return gym;
        */


    }
}
