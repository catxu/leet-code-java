package com.catxu.leetcode.question70;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. Climbing Stairs
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * <p>
 * Output: 2
 * <p>
 * Explanation: There are two ways to climb to the top.
 * <p>
 * 1. 1 step + 1 step
 * <p>
 * 2. 2 steps
 * <p>
 * Example 2:
 * <p>
 * Input: n = 3
 * <p>
 * Output: 3
 * <p>
 * Explanation: There are three ways to climb to the top.
 * <p>
 * 1. 1 step + 1 step + 1 step
 * <p>
 * 2. 1 step + 2 steps
 * <p>
 * 3. 2 steps + 1 step
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 45
 */
class Solution {
    private final Map<Integer, Integer> memoizer = new HashMap<>(64);

    public int climbStairs(int n) {
        if (memoizer.containsKey(n)) {
            return memoizer.get(n);
        }
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        memoizer.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        return memoizer.get(n);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.climbStairs(2));
//        System.out.println(s.climbStairs(3));
//        System.out.println(s.climbStairs(4));
        System.out.println(s.climbStairs(5));
//        System.out.println(s.climbStairs(10));
//        System.out.println(s.climbStairs(45));
    }
}
