package com.catxu.leetcode.question1760;

/**
 * 1760. Minimum Limit of Balls in a Bag
 * <p>
 * You are given an integer array nums where the i<sup>th</sup> bag contains nums[i] balls. You are also given an integer maxOperations.
 * <p>
 * You can perform the following operation at most maxOperations times:
 * <p>
 * Take any bag of balls and divide it into two new bags with a positive number of balls.
 * <p>
 * For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.
 * <p>
 * Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.
 * <p>
 * Return the minimum possible penalty after performing the operations.
 * <p>
 * Example 1:
 * <pre>
 * Input: nums = [9], maxOperations = 2
 * Output: 3
 * Explanation:
 * - Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3].
 * - Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3].
 * The bag with the most number of balls has 3 balls, so your penalty is 3 and you should return 3.
 * </pre>
 * Example 2:
 * <pre>
 * Input: nums = [2,4,8,2], maxOperations = 4
 * Output: 2
 * Explanation:
 * - Divide the bag with 8 balls into two bags of sizes 4 and 4. [2,4,8,2] -> [2,4,4,4,2].
 * - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,4,4,4,2] -> [2,2,2,4,4,2].
 * - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,4,4,2] -> [2,2,2,2,2,4,2].
 * - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2].
 * The bag with the most number of balls has 2 balls, so your penalty is 2, and you should return 2.
 * </pre>
 * Constraints:
 * <pre>
 * 1 <= nums.length <= 10<sup>5</sup>
 * 1 <= maxOperations, nums[i] <= 10<sup>9</sup>
 * </pre>
 */
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int left = 1, right = max;
        while (left < right) {
            int mid = (left + right) / 2;
            int ops = 0;
            for (int num : nums) {
                if (num > mid) {
                    ops += Math.ceilDiv(num, mid) - 1;
                    if (ops > maxOperations) {
                        break;
                    }
                }
            }
            if (ops > maxOperations) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSize(new int[]{9}, 2));
        System.out.println(new Solution().minimumSize(new int[]{2, 4, 8, 2}, 4));
    }
}
