package com.xpanxion.java.springboot.da1.demo.service.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Gym1;
import com.xpanxion.java.springboot.da1.demo.model.student1.GymMember1;
import com.xpanxion.java.springboot.da1.demo.model.student1.Timestamps1;
import com.xpanxion.java.springboot.da1.demo.repository.student1.GymMemberRepository1;
import com.xpanxion.java.springboot.da1.demo.repository.student1.GymRepository1;
import com.xpanxion.java.springboot.da1.demo.repository.student1.TimestampsRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class GymService1 {

    @Autowired
    private GymRepository1 gymRepository1;

    @Autowired
    private GymMemberRepository1 gymMemberRepository1;

    @Autowired
    private TimestampsRepository1 timestampsRepository1;

    public void addGym(Gym1 gym) {

        gymRepository1.save(gym);

    }

    public List<Gym1> findGym(String name) {

        return gymRepository1.findByNameContaining(name);

    }

    public AtomicReference<String> addGymMember(int gymId, GymMember1 gymMember1) {

        AtomicReference<String> result = new AtomicReference<>("Gym Added!");

        gymMember1.setGymId(gymId);
        Optional<Gym1> gym = gymRepository1.findById(gymId);
        gym.ifPresentOrElse(
                gym1 -> gymMemberRepository1.save(gymMember1),
                () -> result.set("Gym not found!")
                );

        return result;
    }

    public AtomicReference<String> checkIn(int memberId, String checkIn) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date checkInGym = (Date) sdf.parse(checkIn);
        AtomicReference<String> result = new AtomicReference<>("Member checked in!");
        Timestamps1 timestamps1 = new Timestamps1(0, memberId, checkInGym, null);
        Optional<GymMember1> gymMember = gymMemberRepository1.findById(memberId);
        gymMember.ifPresentOrElse(
                gymMember1 -> timestampsRepository1.save(timestamps1),
                () -> result.set("Member not found!")
        );

        return result;

    }

    public AtomicReference<String> checkOut(int memberId, String checkOut) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date checkOutGym = (Date) sdf.parse(checkOut);
        AtomicReference<String> result = new AtomicReference<>("Member checked out!");

        Optional<Timestamps1> timestamps = timestampsRepository1.findByMemberId(memberId);
        timestamps.ifPresentOrElse(
                timestamps1 -> {
                    timestamps1.setCheckOut(checkOutGym);
                    timestampsRepository1.save(timestamps1);
                },
                () -> result.set("Member not found!")
        );

        return result;

    }

}
