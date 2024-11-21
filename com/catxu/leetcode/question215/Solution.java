package com.catxu.leetcode.question215;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * <p>
 * Given an integer array nums and an integer k, return the k<sup>th</sup> largest element in the array.
 * <p>
 * Note that it is the k<sup>th</sup> largest element in the sorted order, not the k<sup>th</sup> distinct element.
 * <p>
 * Can you solve it without sorting?
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,1,5,6,4], k = 2
 * <p>
 * Output: 5
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * <p>
 * Output: 4
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= nums.length <= 10<sup>5</sup>
 * <p>
 * -10<sup>4</sup> <= nums[i] <= 10<sup>4</sup>
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(s.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
