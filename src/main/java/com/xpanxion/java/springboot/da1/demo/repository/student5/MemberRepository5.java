package com.xpanxion.java.springboot.da1.demo.repository.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.Member5;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository5 extends JpaRepository<Member5, Integer> {
}
