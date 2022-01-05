package com.xpanxion.java.springboot.da1.demo.service.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Member9;
import com.xpanxion.java.springboot.da1.demo.model.student9.MemberHistory9;
import com.xpanxion.java.springboot.da1.demo.model.student9.WorkoutLength9;
import com.xpanxion.java.springboot.da1.demo.repository.student9.MemberHistoryRepository9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class MemberHistoryService9 {
    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    private MemberHistoryRepository9 memberHistoryRepository9;

    @Autowired
    private MemberService9 memberService9;

    //Methods
    public MemberHistory9 addMemberCheckInHistory(int memberId, LocalDateTime time){

        var member9 = new Member9();
        try {
            member9 = memberService9.getFindById(memberId);
        } catch (ResponseStatusException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        var historyList = memberHistoryRepository9.getMemberWorkoutHistory(memberId);
        var lastHistory = historyList.get(historyList.size()-1);

        if(lastHistory.getCheckOut() == null){
            lastHistory.setCheckOut(time);
           return memberHistoryRepository9.save(lastHistory);
        }
            var memberHistory = new MemberHistory9(member9);
                 memberHistory.setCheckIn(time);
           return memberHistoryRepository9.save(memberHistory);

    }

    public MemberHistory9 addMemberCheckOutHistory(int memberId, LocalDateTime time){
        var member9 = new Member9();

        try {
            member9 = memberService9.getFindById(memberId);
        } catch (ResponseStatusException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        var historyList = memberHistoryRepository9.getMemberWorkoutHistory(memberId);
        var lastHistory = historyList.get(historyList.size()-1);

        if(lastHistory.getCheckIn() == null){
            var memberHistory = new MemberHistory9(member9);
            memberHistory.setCheckIn(time);
            return memberHistoryRepository9.save(memberHistory);
        }
            lastHistory.setCheckOut(time);
           return memberHistoryRepository9.save(lastHistory);
    }

    public StringBuilder getMemberWorkOutHistory(int id){
       var tempList =  memberHistoryRepository9.getMemberWorkoutHistory(id);
       var newList = new StringBuilder();
       for(var index = 0; index < tempList.size(); index++){
           newList.append("{");
           newList.append("\n");
          newList.append("Member Id: ").append(tempList.get(index).getMemberId().getMemberId());
          newList.append("\n");
          newList.append("CheckIn: ").append(tempList.get(index).getCheckIn());
           newList.append("\n");
          newList.append("CheckOut: ").append(tempList.get(index).getCheckOut());
           newList.append("\n").append("}");
           newList.append("\n"); newList.append("\n");
       }
       return newList;
    }

    public WorkoutLength9 getMemberWorkOutLength(int id, String type){

        WorkoutLength9 retrieval = null;

        if(type.equalsIgnoreCase("min")){
            var tempList = memberHistoryRepository9.getWorkoutLengthMin(id);
            var l = tempList.stream().map(m -> {
                var duration = Duration.between(m.getCheckIn(), m.getCheckOut());
                var memberId=  m.getMemberId().getMemberId();
                var date = m.getCheckIn().toLocalDate();
                return new WorkoutLength9(duration.toMinutes(), memberId, date);
            }).toList();

            retrieval =  l.get(0);

        } else if(type.equalsIgnoreCase("max")){
            var tempList = memberHistoryRepository9.getWorkoutLengthMax(id);
            var l = tempList.stream().map(m -> {
                var duration = Duration.between(m.getCheckIn(), m.getCheckOut());
                var memberId=  m.getMemberId().getMemberId();
                var date = m.getCheckIn().toLocalDate();
                return new WorkoutLength9(duration.toMinutes(), memberId, date);
            }).toList();

            retrieval =  l.get(0);
        } // else doNothing()
        return retrieval;
    }
}
