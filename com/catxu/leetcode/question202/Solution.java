package com.catxu.leetcode.question202;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 * <p>
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * <p>
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * <p>
 * Those numbers for which this process ends in 1 are happy.
 * <p>
 * Return true if n is a happy number, and false if not.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 19
 * <p>
 * Output: true
 * <p>
 * Explanation:
 * <p>
 * 1<sup>2</sup> + 9<sup>2</sup> = 82
 * <p>
 * 8<sup>2</sup> + 2<sup>2</sup> = 68
 * <p>
 * 6<sup>2</sup> + 8<sup>2</sup> = 100
 * <p>
 * 1<sup>2</sup> + 0<sup>2</sup> + 0<sup>2</sup> = 1
 * <p>
 * Example 2:
 * <p>
 * Input: n = 2
 * <p>
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 2<sup>31</sup> - 1
 */
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (!visited.contains(n)) {
            visited.add(n);
            n = calcSum(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private int calcSum(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += (digit * digit);
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isHappy(19));
        System.out.println(s.isHappy(2));
        System.out.println(s.isHappy(3));
        System.out.println(s.isHappy(Integer.MAX_VALUE));
        System.out.println(s.isHappy(0));
    }
}