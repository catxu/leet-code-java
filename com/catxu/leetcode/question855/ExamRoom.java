package com.catxu.leetcode.question855;

import java.util.TreeSet;

/**
 * 855. Exam Room
 * <p>
 * There is an exam room with n seats in a single row labeled from 0 to n - 1.
 * <p>
 * When a student enters the room, they must sit in the seat that maximizes the distance to the closest person. If there are multiple such seats, they sit in the seat with the lowest number. If no one is in the room, then the student sits at seat number 0.
 * <p>
 * Design a class that simulates the mentioned exam room.
 * <p>
 * Implement the ExamRoom class:
 * <p>
 * ExamRoom(int n) Initializes the object of the exam room with the number of the seats n.
 * <p>
 * int seat() Returns the label of the seat at which the next student will set.
 * <p>
 * void leave(int p) Indicates that the student sitting at seat p will leave the room. It is guaranteed that there will be a student sitting at seat p.
 * <p>
 * Example 1:
 * <pre>
 * Input
 * ["ExamRoom", "seat", "seat", "seat", "seat", "leave", "seat"]
 * [[10], [], [], [], [], [4], []]
 * Output
 * [null, 0, 9, 4, 2, null, 5]
 * </pre>
 * Explanation
 * <pre>
 * {@code
 * ExamRoom examRoom = new ExamRoom(10);
 * examRoom.seat(); // return 0, no one is in the room, then the student sits at seat number 0.
 * examRoom.seat(); // return 9, the student sits at the last seat number 9.
 * examRoom.seat(); // return 4, the student sits at the last seat number 4.
 * examRoom.seat(); // return 2, the student sits at the last seat number 2.
 * examRoom.leave(4);
 * examRoom.seat(); // return 5, the student sits at the last seat number 5.
 * }
 * </pre>
 * Constraints:
 * <pre>
 * 1 <= n <= 10<sup>9</sup>
 * It is guaranteed that there is a student sitting at seat p.
 * At most 10<sup>4</sup> calls will be made to seat and leave.
 * </pre>
 */
class ExamRoom {
    private final TreeSet<Integer> seats;
    private final int N;

    public ExamRoom(int n) {
        seats = new TreeSet<>();
        this.N = n;
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }

        int seatToTake = -1;
        int maxDistance = -1;

        // 1. 判断第一个位置是否已分配
        if (seats.first() != 0) {
            maxDistance = seats.first();
            seatToTake = 0;
        }

        // 2. 遍历已分配座位之间的距离，找出maxDistance
        int prev = -1;
        for (int seat : seats) {
            if (prev != -1) {
                int distance = (seat - prev) / 2;
                // 根据题设，两个一样的距离取小值
                if (distance > maxDistance) {
                    seatToTake = prev + distance;
                    maxDistance = distance;
                }
            }
            prev = seat;
        }

        // 判断最后一个位置的距离
        if (seats.last() != N - 1) {
            int distance = N - 1 - seats.last();
            if (distance > maxDistance) {
                seatToTake = N - 1;
            }
        }
        seats.add(seatToTake);
        return seatToTake;
    }

    public void leave(int p) {
        seats.remove(p);
    }

    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(4);
        System.out.println(examRoom.seat());
    }
}
