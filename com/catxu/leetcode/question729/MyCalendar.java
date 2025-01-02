package com.catxu.leetcode.question729;

import java.util.ArrayList;
import java.util.List;

/**
 * 729. My Calendar I
 */
class MyCalendar {

    private List<int[]> events;

    public MyCalendar() {
        this.events = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for (int[] event : events) {
            if (/*包括*/(startTime <= event[0] && endTime >= event[1]) || /*左在其中*/(startTime >= event[0] && startTime < event[1]) || /*右在其中*/(endTime > event[0] && endTime < event[1])) {
                return false;
            }
        }
        events.add(new int[]{startTime, endTime});
        return true;
    }

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20));
//        System.out.println(calendar.book(15, 25));
//        System.out.println(calendar.book(20, 30));
//        System.out.println(calendar.book(15, 16));
//        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(8, 19));
    }
}
