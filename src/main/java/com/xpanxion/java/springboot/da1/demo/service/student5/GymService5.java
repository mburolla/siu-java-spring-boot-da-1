package com.xpanxion.java.springboot.da1.demo.service.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.Gym5;
import com.xpanxion.java.springboot.da1.demo.repository.student5.GymRepository5;
import com.xpanxion.java.springboot.da1.demo.view.student5.FindGymsView5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GymService5 {

    @Autowired
    private GymRepository5 gymRepository;

    public List<FindGymsView5> findAllByNameContaining(String name) {
        return gymRepository.findAllByNameContaining(name)
                .stream()
                .map(gym -> new FindGymsView5(gym.getGymId(), gym.getName()))
                .collect(Collectors.toList());
    }

    public Gym5 addGym(Gym5 gym) {
        return gymRepository.save(gym);
    }

    public Gym5 findGym(Long gymId) {
        return gymRepository.findGymByGymId(gymId);
    }
}
