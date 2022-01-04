package com.xpanxion.java.springboot.da1.demo.service.student5;

import com.xpanxion.java.springboot.da1.demo.model.student5.Gym5;
import com.xpanxion.java.springboot.da1.demo.model.student5.Member5;
import com.xpanxion.java.springboot.da1.demo.repository.student5.MemberRepository5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MemberService5 {

    @Autowired
    private MemberRepository5 memberRepository;

    public Member5 addMember(Member5 member, Gym5 gym) {
        if (gym == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gym id not found");
        member.setGym(gym);
        return memberRepository.save(member);
    }

    public Member5 getMember(Long memberId){
        var member = memberRepository.findById(memberId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found."));
        return member;
    }

    //Helper Methods
    public void validateMember(Long memberId) {
        var member = memberRepository.findById(memberId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found."));
    };
}
