package com.xpanxion.java.springboot.da1.demo.service.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.WorkoutHistory5;
import com.xpanxion.java.springboot.da1.demo.repository.student5.WorkoutHistoryRepository5;
import com.xpanxion.java.springboot.da1.demo.view.student5.WorkoutHistoryView5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkoutHistoryService5 {

    @Autowired
    private WorkoutHistoryRepository5 workoutHistoryRepository;
    @Autowired
    private MemberService5 memberService;

    public WorkoutHistory5 workoutCheckIn(Long memberId, Date time) {
        var member = memberService.getMember(memberId);
        return workoutHistoryRepository.save(new WorkoutHistory5(time, WorkoutHistory5.CheckType.CHECK_IN, member));
    }

    public WorkoutHistory5 workoutCheckOut(Long memberId, Date time) {
        var member = memberService.getMember(memberId);
        return workoutHistoryRepository.save(new WorkoutHistory5(time, WorkoutHistory5.CheckType.CHECK_OUT, member));
    }

    public List<WorkoutHistoryView5> findAllByMemberMemberId(Long memberId) {
        var member = memberService.getMember(memberId);
        return workoutHistoryRepository.findAllByMemberMemberId(member.getMemberId()).stream()
                .map(c -> new WorkoutHistoryView5(c.getMember().getMemberId(), c.getTimeUtc(), c.getCheckType())).toList();
    }
}