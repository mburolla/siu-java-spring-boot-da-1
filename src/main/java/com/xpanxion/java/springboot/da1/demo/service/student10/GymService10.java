package com.xpanxion.java.springboot.da1.demo.service.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.Gym10;
import com.xpanxion.java.springboot.da1.demo.model.student10.GymMember10;
import com.xpanxion.java.springboot.da1.demo.repository.student10.GymMemberRepository10;
import com.xpanxion.java.springboot.da1.demo.repository.student10.GymRepository10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class GymService10 {

    //Data Members
    @PersistenceContext
    public EntityManager entityManager;
    @Autowired
    private GymRepository10 gymRepository;
    @Autowired
    private static GymMemberRepository10 memberRepository;

    //Methods
    public Gym10 addGym(Gym10 gym) {
        return gymRepository.save(gym);
    }

    public List<Gym10> findByNameContaining(String gymName) {
        return gymRepository.findByNameContaining(gymName);
    }
}
