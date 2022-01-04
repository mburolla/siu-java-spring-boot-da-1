package com.xpanxion.java.springboot.da1.demo.service.student8;

import com.xpanxion.java.springboot.da1.demo.model.student8.Gym8;
import com.xpanxion.java.springboot.da1.demo.model.student8.Member8;
import com.xpanxion.java.springboot.da1.demo.model.student8.Timestamp8;
import com.xpanxion.java.springboot.da1.demo.repository.student8.GymRepository8;
import com.xpanxion.java.springboot.da1.demo.repository.student8.MemberRepository8;
import com.xpanxion.java.springboot.da1.demo.repository.student8.TimestampRepository8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
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

    public Member8 addMember(Member8 member) {
        return memberRepository8.save(member);
    }

    public Member8 findMemberById(Integer memberId){
        return memberRepository8.getById(memberId);
    }

    public Timestamp8 memberCheckIn(Integer memberId, String checkInTime) {
        if (memberRepository8.findById(memberId).isPresent()) {
            var timestamp = new Timestamp8(memberId, checkInTime);
            return timestampRepository8.save(timestamp);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Timestamp8 memberCheckOut(Integer memberId, String checkOutTime) {
        if(memberRepository8.findById(memberId).isPresent()){
            Timestamp8 timestamp = timestampRepository8.findTopByMemberId(memberId);
            if (timestamp.getCheckOutTime() == null) {
                timestamp.setCheckOutTime(checkOutTime);
            }
            timestampRepository8.save(timestamp);
            return timestamp;
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
