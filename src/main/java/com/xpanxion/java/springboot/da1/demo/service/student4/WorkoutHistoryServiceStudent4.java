package com.xpanxion.java.springboot.da1.demo.service.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.MemberHistory4;
import com.xpanxion.java.springboot.da1.demo.model.student4.Workout4;
import com.xpanxion.java.springboot.da1.demo.repository.student4.WorkoutHistoryRepository4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class WorkoutHistoryServiceStudent4 {

        @Autowired
        private WorkoutHistoryRepository4 workoutHistoryRepository;
        @Autowired
        private MemberServiceStudent4 memberService;

        public Workout4 workoutCheckIn(Long memberId, Date time) {
                var member = memberService.getMember(memberId);
                return workoutHistoryRepository.save(new Workout4(time, Workout4.CheckType.CHECK_IN, member));
        }

        public Workout4 workoutCheckOut(Long memberId, Date time) {
                var member = memberService.getMember(memberId);
                return workoutHistoryRepository.save(new Workout4(time, Workout4.CheckType.CHECK_OUT, member));
        }
        public List<MemberHistory4> findAllByMemberMemberId(Long memberId) {
                var member = memberService.getMember(memberId);
                return workoutHistoryRepository.findAllByMemberMemberId(member.getMemberId()).stream()
                        .map(c -> new MemberHistory4(c.getMember().getMemberId(), c.getTimeUtc(), c.getCheckType())).toList();
        }
}


