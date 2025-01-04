package com.catxu.leetcode.question732;

import java.util.Map;
import java.util.TreeMap;

/**
 * 732. My Calendar III
 */
class MyCalendarThree {

    private final Map<Integer, Integer> stops;

    public MyCalendarThree() {
        this.stops = new TreeMap<>();
    }

    public int book(int startTime, int endTime) {
        stops.merge(startTime, 1, Integer::sum);
        stops.merge(endTime, -1, Integer::sum);
        int count = 0, maxOverlap = 0;
        // line sweep
        for (Integer val : stops.values()) {
            count += val;
            maxOverlap = Math.max(count, maxOverlap);
        }
        return maxOverlap;
    }

    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        System.out.println(myCalendarThree.book(10, 20));   // return 1
        System.out.println(myCalendarThree.book(50, 60));   // return 1
        System.out.println(myCalendarThree.book(10, 40));   // return 2
        System.out.println(myCalendarThree.book(5, 15));   // return 3
        System.out.println(myCalendarThree.book(5, 10));   // return 3
        System.out.println(myCalendarThree.book(25, 55));   // return 3
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */
