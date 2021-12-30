package com.xpanxion.java.springboot.da1.demo.controller.student1;

import com.xpanxion.java.springboot.da1.demo.service.student1.GymService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.concurrent.atomic.AtomicReference;

@RequestMapping("student1/api/v1/member/{memberId}")
@RestController
public class GymMemberController1 {

    @Autowired
    GymService1 gymService1;

    @PostMapping(path = "checkin&time={checkInTime}")
    AtomicReference<String> checkInGym(@PathVariable("memberId") int memberId,
                                       @PathVariable("checkInTime") String checkIn) throws ParseException {

        return gymService1.checkIn(memberId, checkIn);

    }

    @PostMapping(path = "checkout&time={checkOutTime}")
    AtomicReference<String> checkOutGym(@PathVariable("memberId") int memberId,
                                        @PathVariable("checkOutTime") String checkOut) throws ParseException {
        System.out.println("memberId= " + memberId);
        return gymService1.checkOut(memberId, checkOut);

    }

}
