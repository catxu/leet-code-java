package com.catxu.leetcode.question2274;

import java.util.Arrays;

/**
 * 2274. Maximum Consecutive Floors Without Special Floors
 * <p>
 * Alice manages a company and has rented some floors of a building as office space. Alice has decided some of these floors should be special floors, used for relaxation only.
 * <p>
 * You are given two integers bottom and top, which denote that Alice has rented all the floors from bottom to top (inclusive). You are also given the integer array special, where special[i] denotes a special floor that Alice has designated for relaxation.
 * <p>
 * Return the maximum number of consecutive floors without a special floor.
 * <p>
 * Example 1:
 * <pre>
 * Input: bottom = 2, top = 9, special = [4,6]
 * Output: 3
 * Explanation: The following are the ranges (inclusive) of consecutive floors without a special floor:
 * - (2, 3) with a total amount of 2 floors.
 * - (5, 5) with a total amount of 1 floor.
 * - (7, 9) with a total amount of 3 floors.
 * Therefore, we return the maximum number which is 3 floors.
 * </pre>
 * Example 2:
 * <pre>
 * Input: bottom = 6, top = 8, special = [7,6,8]
 * Output: 0
 * Explanation: Every floor rented is a special floor, so we return 0.
 * </pre>
 * <p>
 * Constraints:
 * <p>
 * 1 <= special.length <= 10<sup>5</sup>
 * <p>
 * 1 <= bottom <= special[i] <= top <= 10<sup>9</sup>
 * <p>
 * All the values of special are unique.
 */
class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int ans = special[0] - bottom;
        for (int i = 1; i < special.length; i++) {
            ans = Math.max(ans, special[i] - special[i - 1] - 1);
        }
        ans = Math.max(ans, top - special[special.length - 1]);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxConsecutive(2, 9, new int[]{4, 6}));
        System.out.println(new Solution().maxConsecutive(6, 8, new int[]{7, 6, 8}));
        System.out.println(new Solution().maxConsecutive(6, 8, new int[]{8}));
    }

}
