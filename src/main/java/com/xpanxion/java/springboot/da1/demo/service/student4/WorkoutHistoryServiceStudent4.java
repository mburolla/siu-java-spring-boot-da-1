package com.xpanxion.java.springboot.da1.demo.service.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.WorkoutHistory4;
import com.xpanxion.java.springboot.da1.demo.model.student4.WorkoutPresentation4;
import com.xpanxion.java.springboot.da1.demo.repository.student4.WorkoutHistoryRepositoryStudent4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkoutHistoryServiceStudent4 {
    @Autowired
        private WorkoutHistoryRepositoryStudent4 workoutHistoryRepository;
        @Autowired
        private MemberServiceStudent4 memberService;

        public WorkoutHistory4 workoutCheckIn(Long memberId, Date time) {
            var member = memberService.getMember(memberId);
            return workoutHistoryRepository.save(new WorkoutHistory4(time, WorkoutHistory4.CheckType.CHECK_IN, member));
        }

        public WorkoutHistory4 workoutCheckOut(Long memberId, Date time) {
            var member = memberService.getMember(memberId);
            return workoutHistoryRepository.save(new WorkoutHistory4(time, WorkoutHistory4.CheckType.CHECK_OUT, member));
        }

        public List<WorkoutHistory4> findAllByMemberMemberId(Long memberId) {
            var member = memberService.getMember(memberId);
            return workoutHistoryRepository.findAllByMemberMemberId(member.getMemberId()).stream()
                    .map(c -> {
                       var t = c.getTimeUtc();
                       var ct = c.getCheckType();
                       var mid = c.getMember().getMemberId();
                       return c;
                   }).toList();


        }
}
