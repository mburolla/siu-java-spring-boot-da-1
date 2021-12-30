package com.xpanxion.java.springboot.da1.demo.repository.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Gym1;
import com.xpanxion.java.springboot.da1.demo.model.student1.GymMember1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymMemberRepository1 extends JpaRepository<GymMember1, Integer> { }
