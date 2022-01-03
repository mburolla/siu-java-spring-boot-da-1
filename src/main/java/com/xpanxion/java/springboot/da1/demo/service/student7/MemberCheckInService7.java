package com.xpanxion.java.springboot.da1.demo.service.student7;

import com.xpanxion.java.springboot.da1.demo.model.student7.MemberCheckIn7;
import com.xpanxion.java.springboot.da1.demo.repository.student7.MemberCheckInRepository7;
import com.xpanxion.java.springboot.da1.demo.repository.student7.MemberRepository7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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

}
