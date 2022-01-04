package com.xpanxion.java.springboot.da1.demo.repository.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.Member7;
import com.xpanxion.java.springboot.da1.demo.model.student7.MemberCheckIn7;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberCheckInRepository7 extends JpaRepository<MemberCheckIn7, Integer> {

    @Query(value = "SELECT * FROM member_check_in7 WHERE member_id = ?1",
    nativeQuery = true)
    List<MemberCheckIn7> findByMemberId(int memberId);
}
