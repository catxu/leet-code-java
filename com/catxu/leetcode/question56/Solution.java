package com.catxu.leetcode.question56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. Merge Intervals
 * <p>
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * <p>
 * Output: [[1,6],[8,10],[15,18]]
 * <p>
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * <p>
 * Example 2:
 * <p>
 * Input: intervals = [[1,4],[4,5]]
 * <p>
 * Output: [[1,5]]
 * <p>
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        quickSort(intervals, 0, intervals.length - 1);
        List<int[]> mergedList = new ArrayList<>();
        int[] currentInterval = intervals[0];
        mergedList.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {
            int currentEnd = currentInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (currentEnd >= nextStart) {
                // Overlapping intervals, merge them
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // Non-overlapping interval, add to the list
                currentInterval = intervals[i];
                mergedList.add(currentInterval);
            }
        }

        return mergedList.stream()
                .map(arr -> new int[]{arr[0], arr[1]})
                .toArray(int[][]::new);
    }

    private boolean isInRange(List<Integer[]> arrays, int[] current) {
        Integer[] last = arrays.getLast();
        if (current[0] <= last[1]) {
            last[1] = Math.max(last[1], current[1]);
            return true;
        }
        return false;
    }

    private void quickSort(int[][] intervals, int start, int end) {
        if (end <= start) {
            return;
        }
        int pivot = partition(intervals, start, end);
        quickSort(intervals, start, pivot - 1);
        quickSort(intervals, pivot + 1, end);
    }

    private int partition(int[][] intervals, int start, int end) {
        int pivot = intervals[end][0];
        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            if (intervals[j][0] < pivot) {
                i++;
                swap(intervals, i, j);
            }
        }
        i++;
        swap(intervals, i, end);

        return i;
    }

    private void swap(int[][] board, int i, int j) {
        int[] temp = board[i];
        board[i] = board[j];
        board[j] = temp;
    }

    public static void main(String[] args) {
        int[][] merge1 = new Solution().merge(new int[][]{
                {1, 3}, {2, 6}, {1, 10}, {15, 18}
        });
        for (int[] arry : merge1) {
            System.out.println(Arrays.toString(arry));
        }
        int[][] merge2 = new Solution().merge(new int[][]{
                {1, 4}, {4, 4}
        });
        for (int[] arry : merge2) {
            System.out.println(Arrays.toString(arry));
        }
        int[][] merge3 = new Solution().merge(new int[][]{
                {4, 4}
        });
        for (int[] arry : merge3) {
            System.out.println(Arrays.toString(arry));
        }
    }
}
