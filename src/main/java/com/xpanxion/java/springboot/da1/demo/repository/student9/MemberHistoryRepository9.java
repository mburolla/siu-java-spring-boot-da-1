package com.xpanxion.java.springboot.da1.demo.repository.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.MemberHistory9;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberHistoryRepository9  extends JpaRepository<MemberHistory9, Integer> {

}
