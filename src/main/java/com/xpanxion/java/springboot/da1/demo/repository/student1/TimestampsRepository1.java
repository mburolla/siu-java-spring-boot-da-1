package com.xpanxion.java.springboot.da1.demo.repository.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Timestamps1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public interface TimestampsRepository1 extends JpaRepository<Timestamps1, Integer> {

    Optional<ArrayList<Timestamps1>> findByMemberId(int memberId);

    Optional<Timestamps1> findById(AtomicInteger id);

}
