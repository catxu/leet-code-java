package com.catxu.leetcode.question128;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 128. Longest Consecutive Sequence
 * <p>
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [100,4,200,1,3,2]
 * <p>
 * Output: 4
 * <p>
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * <p>
 * Output: 9
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 10<sup>5</sup>
 * <p>
 * -10<sup>9</sup> <= nums[i] <= 10<sup>9</sup>
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Iterator<Integer> iterator = set.iterator();
        int result = 1;
        int cur = 1;
        int prev = Integer.MIN_VALUE;
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            if (num - 1 == prev) {
                // 计算连续
                cur++;
                result = Math.max(cur, result);
            } else {
                cur = 1;
            }
            prev = num;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(s.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(s.longestConsecutive(new int[]{0}));
        System.out.println(s.longestConsecutive(new int[]{}));
    }
}