package com.catxu.leetcode.question855;

import java.util.TreeSet;

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
