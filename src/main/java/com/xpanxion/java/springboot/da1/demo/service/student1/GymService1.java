package com.xpanxion.java.springboot.da1.demo.service.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Gym;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.student1.GymRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymService1 {

    @Autowired
    private GymRepository1 gymRepository1;

    public void addGym(Gym gym) {

        var id = gym.getId();
        var name = gym.getName();
        var street1 = gym.getStreet1();
        var street2 = gym.getStreet2();
        var city = gym.getCity();
        var state = gym.getState();
        var zip = gym.getZip();

        Gym newGym = new Gym(id, name, street1, street2, city, state, zip);
        gymRepository1.save(newGym);

    }

}
