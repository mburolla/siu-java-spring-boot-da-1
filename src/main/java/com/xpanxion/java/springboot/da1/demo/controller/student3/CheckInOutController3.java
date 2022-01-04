package com.xpanxion.java.springboot.da1.demo.controller.student3;

import com.xpanxion.java.springboot.da1.demo.model.student3.CheckInOut3;
import com.xpanxion.java.springboot.da1.demo.model.student3.CheckType3;
import com.xpanxion.java.springboot.da1.demo.model.student3.WorkoutHistoryPresentation;
import com.xpanxion.java.springboot.da1.demo.model.student3.WorkoutTime;
import com.xpanxion.java.springboot.da1.demo.service.student3.GymService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CheckInOutController3 {

    @Autowired
    private GymService3 gymService3;

    private CheckType3 checkType;

    //
    //GetMap
    //

    @GetMapping("student3/api/v1/member/{memberId}/workout-history")
    public List<WorkoutHistoryPresentation> getWorkoutHistory(@PathVariable int memberId){
        return gymService3.getWorkoutHistory(memberId);
    }

//    @GetMapping("student3/api/v1/member/{memberId}/workout?type={min|max}")
//    public List<WorkoutTime> getWorkoutTime(@PathVariable int memberId){
//        return null;
//    }

    //
    //PostMap
    //

    @PostMapping("student3/api/v1/member/{memberId}/checkin")
    public CheckInOut3 addCheckIn(@RequestParam String time, @PathVariable int memberId){
        return gymService3.addCheckIn(memberId, time, checkType.CHECKIN);
    }

    @PostMapping("student3/api/v1/member/{memberId}/checkout")
    public CheckInOut3 addCheckOut(@RequestParam String time, @PathVariable int memberId){
        return gymService3.addCheckOut(memberId, time, checkType.CHECKOUT);
    }

    //
    //PutMap
    //

}
