package com.xpanxion.java.springboot.da1.demo.service.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.*;
import com.xpanxion.java.springboot.da1.demo.repository.student8.GymRepository8;
import com.xpanxion.java.springboot.da1.demo.repository.student8.MemberHistoryRepository8;
import com.xpanxion.java.springboot.da1.demo.repository.student8.MemberRepository8;
import com.xpanxion.java.springboot.da1.demo.repository.student8.TimestampRepository8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class GymService8 {

    // DATA

    @Autowired
    private GymRepository8 gymRepository8;

    @Autowired
    private MemberRepository8 memberRepository8;

    @Autowired
    private TimestampRepository8 timestampRepository8;

    @Autowired
    private MemberHistoryRepository8 memberHistoryRepository8;

    // CONSTRUCTOR

    public void GymService8() {}

    // METHODS

    public Gym8 createGym(Gym8 gym) {
        return gymRepository8.save(gym);
    }

    public Optional<Gym8> findById(Integer gymId) {
        return gymRepository8.findById(gymId);
    }

    public List<Gym8> findGym(String name) {
        var gyms = gymRepository8.findByNameContaining(name);
        return gyms;
    }

    public Member8 addMember(Member8 member, Integer gymId) {
        Gym8 gym = gymRepository8.getFindById(gymId);
        if (gym == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gym not found");
        }
        member.setGym(gym);
        return memberRepository8.save(member);
    }

    public Member8 findMember(int memberId) {
        return memberRepository8.getById(memberId);
    }

    public Timestamp8 memberCheckIn(int memberId, Timestamp checkInTime, CheckInOutType8 checkType) {
        if (memberRepository8.findById(memberId).isPresent()) {
            Member8 member = findMember(memberId);
            MemberHistory8 memberRecord = new MemberHistory8(member, checkInTime, checkType);
            memberHistoryRepository8.save(memberRecord);
            Timestamp8 timestamp = new Timestamp8(member, checkInTime);
            return timestampRepository8.save(timestamp);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Timestamp8 memberCheckOut(int memberId, Timestamp checkOutTime, CheckInOutType8 checkType) {
        if (memberRepository8.findById(memberId).isPresent()) {
            Member8 member = findMember(memberId);
            Timestamp8 timestamp = timestampRepository8.findTopByMemberOrderByTimestampIdDesc(member);
            if (timestamp.getCheckOutTime() == null) {
                timestamp.setCheckOutTime(checkOutTime);
            }
            MemberHistory8 memberRecord = new MemberHistory8(member, checkOutTime, checkType);
            memberHistoryRepository8.save(memberRecord);
            timestampRepository8.save(timestamp);
            return timestamp;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<MemberHistoryReport8> getMemberHistory(int memberId) {
        if (memberRepository8.findById(memberId).isPresent()) {
            Member8 member = findMember(memberId);
            var memberHistory = memberHistoryRepository8.getFindByMember(member);
            return memberHistory.stream().map(mh -> new MemberHistoryReport8(mh.getMember().getMemberId(), mh.getTimeUtc(), mh.getCheckType())).toList();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "member not found");
        }
    }
}


