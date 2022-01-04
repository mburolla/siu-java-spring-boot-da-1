package com.xpanxion.java.springboot.da1.demo.service.student1;

import com.xpanxion.java.springboot.da1.demo.model.student1.*;
import com.xpanxion.java.springboot.da1.demo.repository.student1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.DateFormat;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    WorkoutHistory1 workoutHistory1;

    public List<WorkoutHistory1> getWorkoutHistory(Integer memberId) {

        var workoutHistory = workoutHistoryRepository1.findByMemberId(memberId);

        if (workoutHistory.size() == 0 ) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return workoutHistory;

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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date checkInGym = (Date) sdf.parse(checkIn);
        Optional<GymMember1> gymMember = gymMemberRepository1.findById(memberId);
        gymMember.ifPresentOrElse(
                gymMember1 -> {
                    workoutHistoryRepository1.save(new WorkoutHistory1(0, memberId, checkInGym, CheckType.CHECK_IN.name()));
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
                    workoutHistoryRepository1.save(new WorkoutHistory1(0, memberId, checkOutGym, CheckType.CHECK_OUT.name()));
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

    public WorkoutLength1 getWorkoutLength(int memberId, String minOrMax) {

        List<WorkoutLength1> workoutLenths = new ArrayList<>();
        minOrMax = minOrMax.toLowerCase();

        timestampsRepository1.findByMemberId(memberId)
                .ifPresentOrElse( members -> {
                    for (var i = 0; i < members.size(); i++) {
                        try {
                            int minutes = getTimeDifferenceInMinutes(members.get(i).getCheckIn(), members.get(i).getCheckOut());
                            String date = formatDate(members.get(i).getCheckIn());
                            workoutLenths.add(new WorkoutLength1(minutes, memberId, date));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NO_CONTENT);
                });

        switch(minOrMax) {
            case "min":
                return workoutLenths.get(0);
            case "max":
                Collections.sort(workoutLenths);
                return workoutLenths.get(0);
            default:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    private int getTimeDifferenceInMinutes(Date checkIn, Date checkOut) throws ParseException {

        long milliseconds = checkOut.getTime() - checkIn.getTime();
        int seconds = (int) milliseconds / 1000;
        int minutes = Math.abs(seconds / 60 / 60);

        return minutes;

    }

    public String formatDate(Date dayOfWorkout) throws ParseException {

        String[] getDate = dayOfWorkout.toString().split(" ");
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat targetFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = originalFormat.parse(getDate[0]);
        String formattedDate = targetFormat.format(date);


        return formattedDate;

    }

}
