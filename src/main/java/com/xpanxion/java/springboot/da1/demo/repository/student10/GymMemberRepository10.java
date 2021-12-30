package com.xpanxion.java.springboot.da1.demo.repository.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.GymMember10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymMemberRepository10 extends JpaRepository<GymMember10, Integer> {
}