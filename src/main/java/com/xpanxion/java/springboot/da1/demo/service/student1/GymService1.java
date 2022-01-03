package com.xpanxion.java.springboot.da1.demo.service.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.Gym1;
import com.xpanxion.java.springboot.da1.demo.model.student1.GymMember1;
import com.xpanxion.java.springboot.da1.demo.model.student1.Timestamps1;
import com.xpanxion.java.springboot.da1.demo.model.student1.WorkoutHistory1;
import com.xpanxion.java.springboot.da1.demo.repository.student1.GymMemberRepository1;
import com.xpanxion.java.springboot.da1.demo.repository.student1.GymRepository1;
import com.xpanxion.java.springboot.da1.demo.repository.student1.TimestampsRepository1;
import com.xpanxion.java.springboot.da1.demo.repository.student1.WorkoutHistoryRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class GymService1 {

    @Autowired
    private GymRepository1 gymRepository1;

    @Autowired
    private GymMemberRepository1 gymMemberRepository1;

    @Autowired
    private WorkoutHistoryRepository1 workoutHistoryRepository1;

    @Autowired
    private TimestampsRepository1 timestampsRepository1;

    public List<WorkoutHistory1> getWorkoutHistory(Integer memberId) {

        var memberWorkoutHistory = workoutHistoryRepository1.findByMemberId(memberId);

        return memberWorkoutHistory;

    }

    public void addGym(Gym1 gym) {

        gymRepository1.save(gym);

    }

    public List<Gym1> findGym(String name) {

        return gymRepository1.findByNameContaining(name);

    }

    public String addGymMember(int gymId, GymMember1 gymMember1) {

        gymMember1.setGymId(gymId);
        Optional<Gym1> gym = gymRepository1.findById(gymId);
        gym.ifPresentOrElse(
                gym1 -> gymMemberRepository1.save(gymMember1),
                () ->  {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
                );

        return "Gym Member Added!";
    }

    public String checkIn(int memberId, String checkIn) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date checkInGym = (Date) sdf.parse(checkIn);
        Optional<GymMember1> gymMember = gymMemberRepository1.findById(memberId);
        gymMember.ifPresentOrElse(
                gymMember1 -> {
                    workoutHistoryRepository1.save(new WorkoutHistory1(0, memberId, checkInGym, "CHECK_IN"));
                    timestampsRepository1.save(new Timestamps1(0, memberId, checkInGym, null));
                },
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );

        return "Member checked in!";

    }

    public String checkOut(int memberId, String checkOut) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date checkOutGym = (Date) sdf.parse(checkOut);
        Optional<ArrayList<Timestamps1>> timestamps = timestampsRepository1.findByMemberId(memberId);
        Optional<Timestamps1> memberTimestamp;
        timestamps.ifPresentOrElse(
                timestamps1 -> {
                    workoutHistoryRepository1.save(new WorkoutHistory1(0, memberId, checkOutGym, "CHECK_OUT"));
                    for (Timestamps1 value : timestamps1) {
                        if (value.getCheckOut() == null) {
                            value.setCheckOut(checkOutGym);
                            timestampsRepository1.save(value);
                        }
                    }
                },
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );

        return "Member checked out!";

    }

}
