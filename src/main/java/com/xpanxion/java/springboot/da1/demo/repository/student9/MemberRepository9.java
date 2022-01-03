package com.xpanxion.java.springboot.da1.demo.repository.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Member9;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository9 extends JpaRepository<Member9, Integer> {

    Member9 findById(int id);
}
