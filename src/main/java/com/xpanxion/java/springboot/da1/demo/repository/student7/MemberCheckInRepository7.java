package com.xpanxion.java.springboot.da1.demo.repository.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.MemberCheckIn7;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberCheckInRepository7 extends JpaRepository<MemberCheckIn7, Integer> {

}
