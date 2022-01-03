package com.xpanxion.java.springboot.da1.demo.controller.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.GymMember10;
import com.xpanxion.java.springboot.da1.demo.model.student10.Workout10;
import com.xpanxion.java.springboot.da1.demo.service.student10.GymMemberService10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GymMemberController10 {

    @Autowired
    private GymMemberService10 memberService;

    @PostMapping("student10/api/v1/gym/{gymId}/member")
    public GymMember10 addMember(@PathVariable int gymId, @RequestBody GymMember10 gymMember10) {
        return memberService.addMember(gymId, gymMember10);
    }

    @PostMapping("student10/api/v1/member/{memberId}/checkin")
    public Workout10 checkIn(@PathVariable int memberId, @RequestParam String time) {
        return memberService.checkIn(memberId, time);
    }

    @PostMapping("student10/api/v1/member/{memberId}/checkout")
    public Workout10 checkOut(@PathVariable int memberId, @RequestParam String time) {
        return memberService.checkOut(memberId, time);
    }

    @GetMapping("student10/api/v1/member/{memberId}/workout-history")
    public List<Workout10> getWorkoutHistory(@PathVariable int memberId) {
        List<Workout10> workouts = memberService.getWorkoutHistory(memberId);
        return workouts;
    }
}
