package com.xpanxion.java.springboot.da1.demo.repository.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Gym4;
import com.xpanxion.java.springboot.da1.demo.model.student4.Member4;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepositoryStudent4 extends JpaRepository<Member4, Integer> {
}
