package com.catxu.leetcode.question502;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 502. IPO
 */
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{capital[i], profits[i]});
        }

        while (k > 0) {
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= w) {
                int[] cp = minHeap.poll();
                maxHeap.offer(cp[1]);
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll();
            k--;
        }
        return w;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
    }
}
