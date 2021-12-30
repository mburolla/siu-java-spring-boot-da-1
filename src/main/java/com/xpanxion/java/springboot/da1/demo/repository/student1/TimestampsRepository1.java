package com.xpanxion.java.springboot.da1.demo.repository.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Timestamps1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimestampsRepository1 extends JpaRepository<Timestamps1, Integer> {

    Optional<Timestamps1> findByMemberId(int memberId);

}
