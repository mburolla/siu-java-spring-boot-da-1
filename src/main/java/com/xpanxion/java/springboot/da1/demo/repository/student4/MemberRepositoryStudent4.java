package com.xpanxion.java.springboot.da1.demo.repository.student4;


import com.xpanxion.java.springboot.da1.demo.model.student4.Member4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepositoryStudent4 extends JpaRepository<Member4, Integer> {
    Member4 findById(long id);
}
