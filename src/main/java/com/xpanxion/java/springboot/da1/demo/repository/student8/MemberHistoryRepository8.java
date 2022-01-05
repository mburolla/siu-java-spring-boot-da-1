package com.xpanxion.java.springboot.da1.demo.repository.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Member8;
import com.xpanxion.java.springboot.da1.demo.model.student8.MemberHistory8;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberHistoryRepository8 extends JpaRepository<MemberHistory8, Integer> {

    List<MemberHistory8> getFindByMember(Member8 member);
}
