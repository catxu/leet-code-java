package com.catxu.leetcode.question731;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 731. My Calendar II
 * <p>
 * You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a triple booking.
 * <p>
 * A triple booking happens when three events have some non-empty intersection (i.e., some moment is common to all the three events.).
 * <p>
 * The event can be represented as a pair of integers startTime and endTime that represents a booking on the half-open interval [startTime, endTime), the range of real numbers x such that startTime <= x < endTime.
 * <p>
 * Implement the MyCalendarTwo class:
 * <p>
 * MyCalendarTwo() Initializes the calendar object.
 * <p>
 * boolean book(int startTime, int endTime) Returns true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
 * <p>
 * Example 1:
 * <pre>{@code
 * Input
 * ["MyCalendarTwo", "book", "book", "book", "book", "book", "book"]
 * [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
 * Output
 * [null, true, true, true, false, true, true]
 * }
 * </pre>
 * <p>
 * Explanation
 * <pre>
 * {@code
 * MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
 * myCalendarTwo.book(10, 20); // return True, The event can be booked.
 * myCalendarTwo.book(50, 60); // return True, The event can be booked.
 * myCalendarTwo.book(10, 40); // return True, The event can be double booked.
 * myCalendarTwo.book(5, 15);  // return False, The event cannot be booked, because it would result in a triple booking.
 * myCalendarTwo.book(5, 10); // return True, The event can be booked, as it does not use time 10 which is already double booked.
 * myCalendarTwo.book(25, 55); // return True, The event can be booked, as the time in [25, 40) will be double booked with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
 * }
 * </pre>
 * <p>
 * Constraints:
 * <p>
 * 0 <= start < end <= 10<sup>9</sup>
 * <p>
 * At most 1000 calls will be made to book.
 */
class MyCalendarTwo {
    private final Map<Integer, Integer> stops;

    public MyCalendarTwo() {
        stops = new TreeMap<>(Comparator.comparingInt(o -> o));
    }

    public boolean book(int startTime, int endTime) {
        stops.merge(startTime, 1, Integer::sum);
        stops.merge(endTime, -1, Integer::sum);
        int count = 0;
        // line sweep
        for (Integer val : stops.values()) {
            count += val;
            if (count > 2) {
                stops.computeIfPresent(startTime, (k, v) -> v - 1);
                stops.computeIfPresent(endTime, (k, v) -> v + 1);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo calendarII = new MyCalendarTwo();
        System.out.println(calendarII.book(10, 20));
        System.out.println(calendarII.book(50, 60));
        System.out.println(calendarII.book(10, 40));
        System.out.println(calendarII.book(5, 15));
        System.out.println(calendarII.book(5, 15));
        System.out.println(calendarII.book(5, 10));
        System.out.println(calendarII.book(25, 55));
    }

}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */
