package com.xpanxion.java.springboot.da1.demo.repository.student2;

import com.xpanxion.java.springboot.da1.demo.model.student2.Gym2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface GymRepository2 extends JpaRepository <Gym2,Integer>{
    List<Gym2> findByNameContaining(String name);
}
