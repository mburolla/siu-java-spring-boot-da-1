package com.xpanxion.java.springboot.da1.demo.repository.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Member8;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository8 extends JpaRepository<Member8, Integer> {
}
