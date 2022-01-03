package com.xpanxion.java.springboot.da1.demo.repository.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.MemberHistory9;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberHistoryRepository9  extends JpaRepository<MemberHistory9, Integer> {

    @Query(
            value = "SELECT m.history_id,m.member_id, m.check_in, m.check_out FROM member_history9 m WHERE m.member_id = ?",
            nativeQuery = true
    )
    List<MemberHistory9> getMemberWorkoutHistory (int memberId);
}
