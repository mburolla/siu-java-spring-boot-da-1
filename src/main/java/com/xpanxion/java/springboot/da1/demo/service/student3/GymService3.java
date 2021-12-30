package com.xpanxion.java.springboot.da1.demo.service.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.Gym3;
import com.xpanxion.java.springboot.da1.demo.model.student3.Member3;
import com.xpanxion.java.springboot.da1.demo.repository.student3.GymRepository3;
import com.xpanxion.java.springboot.da1.demo.repository.student3.MemberRepository3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GymService3 {

    @Autowired
    private GymRepository3 gymRepository;

    @Autowired
    private MemberRepository3 memberRepository;

    public Gym3 addGym(Gym3 gym){
        return gymRepository.save(gym);
    }

    public List<Gym3> getGym(String name){
        return gymRepository.findByNameContaining(name);
    }

    public Member3 addMember(Member3 member) {return memberRepository.save(member);}
}
