package com.xpanxion.java.springboot.da1.demo.model.student2;

import java.util.Comparator;

public class SortByLength implements Comparator<WorkoutLength2> {
    public int compare(WorkoutLength2 a, WorkoutLength2 b) {
        return a.getLengthInMinutes() - b.getLengthInMinutes();
    }
}
