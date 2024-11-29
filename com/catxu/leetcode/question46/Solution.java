package com.catxu.leetcode.question46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. Permutations
 * <p>
 * Given an array nums of distinct integers, return all the possible
 * permutations
 * . You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * <p>
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * <p>
 * Output: [[0,1],[1,0]]
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1]
 * <p>
 * Output: [[1]]
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 6
 * <p>
 * -10 <= nums[i] <= 10
 * <p>
 * All the integers of nums are unique.
 */
class Solution {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int end = chars.length;
        while (chars[--end] == ' ') {
        }
        int start = end;
        while (start > 0 && chars[--start] != ' ') {
        }
        return end - start + (chars[start] == ' ' ? 0 : 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("luffy is still joyboy"));
    }
}
