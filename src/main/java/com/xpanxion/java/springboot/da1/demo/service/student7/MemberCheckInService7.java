package com.xpanxion.java.springboot.da1.demo.service.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.MemberCheckIn7;
import com.xpanxion.java.springboot.da1.demo.model.student7.WorkOutHistory7;
import com.xpanxion.java.springboot.da1.demo.repository.student7.MemberCheckInRepository7;
import com.xpanxion.java.springboot.da1.demo.repository.student7.MemberRepository7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberCheckInService7 {

    @Autowired
    MemberCheckInRepository7 memberCheckInRepository;
    @Autowired
    MemberRepository7 memberRepository;

    public MemberCheckIn7 checkIn(int memberId, Date timeUtc) {
        MemberCheckIn7 memberCheckIn = new MemberCheckIn7(memberRepository.findById(memberId),
                timeUtc,
                "CHECK_IN" );
        memberCheckInRepository.save(memberCheckIn);
        return memberCheckIn;
    }

    public MemberCheckIn7 checkout(int memberId, Date timeUtc) {
        MemberCheckIn7 memberCheckIn = new MemberCheckIn7(memberRepository.findById(memberId),
                timeUtc,
                "CHECK_OUT");
        memberCheckInRepository.save(memberCheckIn);
        return memberCheckIn;
    }

    public List<WorkOutHistory7> getWorkoutHistory(int memberId) {
        if (memberRepository.findById(memberId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return memberCheckInRepository.findByMemberId(memberId)
                .stream()
                .map(x -> {
                   var m = x.getMemberId().getMemberId();
                   var t  =  x.getTimeUtc();
                   var c=  x.getCheckType();
                   var w = new WorkOutHistory7(m,t,c);
                   return w;
                })
                .toList();


    }

}
