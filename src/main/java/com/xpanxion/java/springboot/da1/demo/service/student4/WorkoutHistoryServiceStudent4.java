package com.xpanxion.java.springboot.da1.demo.service.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Workout4;
import com.xpanxion.java.springboot.da1.demo.model.student4.WorkoutPresentation;
import com.xpanxion.java.springboot.da1.demo.repository.student4.WorkoutRepository4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkoutHistoryServiceStudent4 {

        @Autowired
        private MemberServiceStudent4 memberService;

        @Autowired
        private WorkoutRepository4 workoutRepository4;

        public List<WorkoutPresentation> findAllByMemberId(long memberId) {
            var member = memberService.getMember(memberId);
            var workoutList = workoutRepository4.findByMember(member);
            return workoutList.stream().map(w -> new WorkoutPresentation(555, w.getMember().getMemberId(), "today")).toList();
        }
}

