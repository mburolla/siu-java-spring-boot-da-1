package com.xpanxion.java.springboot.da1.demo.service.instructor;

import com.xpanxion.java.springboot.da1.demo.model.instructor.CheckType;
import com.xpanxion.java.springboot.da1.demo.model.instructor.Gym0;
import com.xpanxion.java.springboot.da1.demo.model.instructor.Member0;
import com.xpanxion.java.springboot.da1.demo.model.instructor.WorkoutHistory0;
import com.xpanxion.java.springboot.da1.demo.model.instructor.response.WorkoutLength;
import com.xpanxion.java.springboot.da1.demo.model.instructor.response.WorkoutTime;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.GymRepository0;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.MemberRepository0;
import com.xpanxion.java.springboot.da1.demo.repository.instructor.WorkoutHistoryRepository0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemberService0 {

    //
    // Data members
    //

    @Autowired
    private GymRepository0 gymRepository0;

    @Autowired
    private MemberRepository0 memberRepository0;

    @Autowired
    private WorkoutHistoryRepository0 workoutHistoryRepository0;

    //
    // Public methods
    //

    public int addMemberToGymId(Member0 member0, int gymId) {
        member0.setGym(getGymOrThrow(gymId));
        return memberRepository0.save(member0).getMemberId();
    }

    public void checkMember(CheckType checkType, int memberId, Date time) {
        var member = getMemberOrThrow(memberId);
        var workoutHistory = new WorkoutHistory0(member, time, checkType);
        workoutHistoryRepository0.save(workoutHistory);
    }

    public List<WorkoutTime> getWorkoutHistory(int memberId) {
        var member = getMemberOrThrow(memberId);
        var workoutHistory = workoutHistoryRepository0.getSortedWorkoutHistory(memberId);
        var retval = workoutHistory.stream().map(w -> new WorkoutTime(member.getMemberId(),w.getTime(),w.getCheckType())).toList();
        return retval;
    }

    public WorkoutLength getWorkout(int memberId, String type) {
        WorkoutLength retval = null;
        var workoutTimeList = getWorkoutHistory(memberId);
        var workoutLengthList = buildSortedWorkoutLengthList(workoutTimeList, memberId);
        if (type.equals("min")) {
            retval = workoutLengthList.get(0);
        }
        if (type.equals("max")) {
            retval = workoutLengthList.get(workoutLengthList.size() - 1);
        }
        return retval;
    }

    //
    // Private methods
    //

    private Member0 getMemberOrThrow(int memberId) {
        var retval= memberRepository0.findById(memberId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found."));
        return retval;
    }

    private Gym0 getGymOrThrow(int gymId) {
        var gym = gymRepository0.findById(gymId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Gym not found."));
        return gym;
    }

    private String parseDate(LocalDateTime localDate) {
        return localDate.getMonthValue() + "/" + localDate.getDayOfMonth() + "/" + localDate.getYear();
    }

    private List<WorkoutLength> buildSortedWorkoutLengthList(List<WorkoutTime> workoutTimeList, int memberId) {
        var retval = new ArrayList<WorkoutLength>();
        Date checkinDate = null;
        Date checkOutDate = null;
        for (WorkoutTime wt: workoutTimeList) {
            if (checkinDate == null && wt.getCheckType() == CheckType.CHECK_IN)
                checkinDate = wt.getTimeUtc();

            if (checkinDate != null && wt.getCheckType() == CheckType.CHECK_OUT)
                checkOutDate = wt.getTimeUtc();

            if (checkinDate != null && checkOutDate != null) {
                var lcid = checkinDate.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();

                var lcod = checkOutDate.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();

                if (parseDate(lcid).equals(parseDate(lcod))) {
                    Duration duration = Duration.between(lcid, lcod);
                    long diffMinutes = Math.abs(duration.toMinutes());
                    retval.add(new WorkoutLength(parseDate(lcid), diffMinutes, memberId));
                }

                checkinDate = null;
                checkOutDate = null;
            }
        }
        return retval.stream().sorted().toList();
    }
}
