package com.xpanxion.java.springboot.da1.demo.repository.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.CheckInOut3;
import com.xpanxion.java.springboot.da1.demo.model.student3.Member3;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CheckInOutRepository3 extends JpaRepository<CheckInOut3, Integer> {

    List<CheckInOut3> findByMember3(Member3 member3);

}
