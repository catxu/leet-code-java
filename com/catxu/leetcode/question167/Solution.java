package com.catxu.leetcode.question167;

import java.util.Arrays;

/**
 * 167. Two Sum II - Input Array Is Sorted
 * <p>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * <p>
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * <p>
 * Your solution must use only constant extra space.
 * <p>
 * Example 1:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * <p>
 * Output: [1,2]
 * <p>
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * <p>
 * Example 2:
 * <p>
 * Input: numbers = [2,3,4], target = 6
 * <p>
 * Output: [1,3]
 * <p>
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * <p>
 * Example 3:
 * <p>
 * Input: numbers = [-1,0], target = -1
 * <p>
 * Output: [1,2]
 * <p>
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 * <p>
 * Constraints:
 * <p>
 * 2 <= numbers.length <= 3 * 10<sup>4</sup>
 * <p>
 * -1000 <= numbers[i] <= 1000
 * <p>
 * numbers is sorted in non-decreasing order.
 * <p>
 * -1000 <= target <= 1000
 * <p>
 * The tests are generated such that there is exactly one solution.
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1, sum;
        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{-1, 0}, -1)));
    }
}
