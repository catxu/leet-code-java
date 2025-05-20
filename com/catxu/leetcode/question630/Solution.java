package com.catxu.leetcode.question630;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 630. Course Schedule III
 */
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]); // 按 lastDay 从小到大排序
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a); // max heap
        int day = 0; // 已消耗时间
        for (int[] c : courses) {
            int duration = c[0], lastDay = c[1];
            // 贪心策略
            // 如果能增大课程数量，就增大课程数量，如果不能增大课程数量，就在保持课程数量不变的前提下，尝试减少总时长，使得后续增大课程数量的概率增加
            if (day + duration <= lastDay) { // 没超过 lastDay，可以直接学习
                day += duration;
                heap.offer(duration);
            } else if (!heap.isEmpty() && heap.peek() > duration) { // 该课程的时间比之前的最长时间要短
                // 反悔，撤销之前 duration 最长的课程，改为学习该课程
                // 节省出来的时间，能在后面上完更多的课程
                day = day - heap.poll() + duration;
                heap.offer(duration);
            }
            // 循环不变式：maxHeap.size() 是当前课程的最优解，且总消耗时间 day 最小
        }
        return heap.size();
    }
}
