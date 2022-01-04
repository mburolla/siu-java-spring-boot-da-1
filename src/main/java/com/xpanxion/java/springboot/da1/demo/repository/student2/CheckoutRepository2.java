package com.xpanxion.java.springboot.da1.demo.repository.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.Checkout2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CheckoutRepository2 extends JpaRepository<Checkout2, Integer> {

    List<Checkout2> findBymember2Id(int id);
}