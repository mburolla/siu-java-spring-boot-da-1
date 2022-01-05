package com.xpanxion.java.springboot.da1.demo.service.student4;

import com.xpanxion.java.springboot.da1.demo.model.student4.Member4;
import com.xpanxion.java.springboot.da1.demo.repository.student4.MemberRepositoryStudent4;
import com.xpanxion.java.springboot.da1.demo.repository.student4.WorkoutHistoryRepository4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MemberServiceStudent4 {

    @Autowired
    private MemberRepositoryStudent4 memberRepositoryStudent4;

    @Autowired
    private WorkoutHistoryRepository4 workoutHistoryRepository;

    public Member4 addMember(Member4 member) {
        return memberRepositoryStudent4.save(member);
    }

    public Member4 getMember(Long memberId){

        var member = memberRepositoryStudent4.findById(memberId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found."));
        return member;
    }
}
