package com.xpanxion.java.springboot.da1.demo.controller.student10;

import com.xpanxion.java.springboot.da1.demo.model.student10.GymMember10;
import com.xpanxion.java.springboot.da1.demo.model.student10.Workout10;
import com.xpanxion.java.springboot.da1.demo.service.student10.GymMemberService10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class GymMemberController10 {

    @Autowired
    private GymMemberService10 memberService;

    @PostMapping("student10/api/v1/gym/{gymId}/member")
    public GymMember10 addMember(@PathVariable int gymId, @RequestBody GymMember10 gymMember10) {
        return memberService.addMember(gymId, gymMember10);
    }

    @PostMapping("student10/api/v1/member/{memberId}/checkin")
    public Workout10 checkIn(@PathVariable int memberId, @RequestParam String time) throws ParseException {
        return memberService.checkIn(memberId, time);
    }

    @PostMapping("student10/api/v1/member/{memberId}/checkout")
    public Workout10 checkOut(@PathVariable int memberId, @RequestParam String time) throws ParseException {
        return memberService.checkOut(memberId, time);
    }

    @GetMapping("student10/api/v1/member/{memberId}/workout-history")
    public List<Workout10> getWorkoutHistory(@PathVariable int memberId) {
        List<Workout10> workouts = memberService.getWorkoutHistory(memberId);
        return workouts;
    }
    /*
    @GetMapping("student10/api/v1/member/{memberId}/workout")
    public List<WorkoutTimes10> getMinMaxWorkout(@PathVariable int memberId, @RequestParam String type){
        List<WorkoutTimes10> times = memberService.getTimes(memberId);
        return times;
    }

     */
}
