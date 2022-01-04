package com.xpanxion.java.springboot.da1.demo.repository.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.Checkin2;
import com.xpanxion.java.springboot.da1.demo.model.student2.Checkout2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CheckinRepository2 extends JpaRepository<Checkin2, Integer> {

    List<Checkin2> findBymember2Id(int id);
}