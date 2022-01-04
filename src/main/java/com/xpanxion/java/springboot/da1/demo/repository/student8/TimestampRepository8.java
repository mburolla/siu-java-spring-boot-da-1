package com.xpanxion.java.springboot.da1.demo.repository.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Timestamp8;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimestampRepository8 extends JpaRepository<Timestamp8, Integer> {
    Timestamp8 findTopByMemberId(int memberId);
}
