package com.xpanxion.java.springboot.da1.demo.service.student9;

import com.xpanxion.java.springboot.da1.demo.model.student9.Member9;
import com.xpanxion.java.springboot.da1.demo.model.student9.MemberHistory9;
import com.xpanxion.java.springboot.da1.demo.repository.student9.MemberHistoryRepository9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

        var member9 = memberService9.getFindById(memberId);
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

        var member9 = memberService9.getFindById(memberId);
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

    public StringBuilder getMemberWorkOutLength(int id, String type){
        var stringBuilder = new StringBuilder();
        if(type.equalsIgnoreCase("min")){
            var tempList = memberHistoryRepository9.getWorkoutLengthMin(id);
            for(var temp : tempList){
                var duration = Duration.between(temp.getCheckIn(), temp.getCheckOut());
                stringBuilder.append("{");
                stringBuilder.append("\n");
                stringBuilder.append("LengthInMinutes: ").append(duration.toMinutes());
                stringBuilder.append("\n");
                stringBuilder.append("Member Id: ").append(temp.getMemberId().getMemberId());
                stringBuilder.append("\n");
                stringBuilder.append("date: ").append(temp.getCheckIn().toLocalDate());
            }
        } else if(type.equalsIgnoreCase("max")){
            var tempList = memberHistoryRepository9.getWorkoutLengthMax(id);
            for(var temp : tempList){
                var duration =  Duration.between(temp.getCheckIn(), temp.getCheckOut());
                stringBuilder.append("{");
                stringBuilder.append("\n");
                stringBuilder.append("LengthInMinutes: ").append(duration.toMinutes());
                stringBuilder.append("\n");
                stringBuilder.append("Member Id: ").append(temp.getMemberId().getMemberId());
                stringBuilder.append("\n");
                stringBuilder.append("date: ").append(temp.getCheckIn().toLocalDate());
                stringBuilder.append("\n").append("}");
                stringBuilder.append("\n");
            }
        } // else doNothing()
        return stringBuilder;
    }
}
