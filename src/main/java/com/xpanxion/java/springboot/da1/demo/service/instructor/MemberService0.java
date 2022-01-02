package com.xpanxion.java.springboot.da1.demo.service.instructor;

import com.xpanxion.java.springboot.da1.demo.model.instructor.CheckType;
import com.xpanxion.java.springboot.da1.demo.model.instructor.Member0;
import com.xpanxion.java.springboot.da1.demo.model.instructor.WorkoutHistory0;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.GymRepository0;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.MemberRepository0;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.WorkoutHistoryRepository0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MemberService0 {

    @Autowired
    private GymRepository0 gymRepository0;

    @Autowired
    private MemberRepository0 memberRepository0;

    @Autowired
    private WorkoutHistoryRepository0 workoutHistoryRepository0;

    public int addMemberToGymId(Member0 member0, int gymId) {
        member0.setGym(gymRepository0.findById(gymId).get());
        return memberRepository0.save(member0).getMemberId();
    }

    public void checkMember(CheckType checkType, int memberId, Date time) {

        var member = memberRepository0.findById(memberId).get();
        workoutHistoryRepository0.save(new WorkoutHistory0(time, memberId, checkType));
    }
}
