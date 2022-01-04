package com.xpanxion.java.springboot.da1.demo.service.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.WorkoutHistory5;
import com.xpanxion.java.springboot.da1.demo.repository.student5.WorkoutHistoryRepository5;
import com.xpanxion.java.springboot.da1.demo.view.student5.WorkoutHistoryView5;
import com.xpanxion.java.springboot.da1.demo.view.student5.WorkoutLengthView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

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

    public WorkoutLengthView findMinMaxByMemberId(Long memberId, String type) {
        List<WorkoutLengthView> workoutLengths = new ArrayList<>();
        memberService.validateMember(memberId);
        Format formatter = new SimpleDateFormat("MM/dd/yy");
        var workoutHistory = workoutHistoryRepository.findAllByMemberMemberId(memberId);
        for (int i = 0; i < workoutHistory.size(); i+=2) {
            String date = formatter.format(workoutHistory.get(i).getTimeUtc());
            var lengthInMinutes = getDateDiff(workoutHistory.get(i).getTimeUtc(), workoutHistory.get(i+1).getTimeUtc());
            workoutLengths.add(new WorkoutLengthView(lengthInMinutes, memberId, date));
        }
        switch (type) {
            case "min" -> {
                return workoutLengths.get(0);
            }
            case "max" -> {
                Collections.sort(workoutLengths);
                return workoutLengths.get(0);
            }
            default -> throw new ResponseStatusException(HttpStatus.NOT_FOUND, "type is invalid");
        }
    }

    //Helper Methods
    public static long getDateDiff(Date date1, Date date2) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return TimeUnit.MINUTES.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
}
