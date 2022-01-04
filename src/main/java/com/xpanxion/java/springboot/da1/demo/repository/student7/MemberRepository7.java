package com.xpanxion.java.springboot.da1.demo.repository.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.Member7;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository7 extends JpaRepository<Member7, Integer> {
    Member7 findById(int id);
}
