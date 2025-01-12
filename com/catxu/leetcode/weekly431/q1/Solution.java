package com.catxu.leetcode.weekly431.q1;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().maxLength(new int[]{1, 2, 1, 2, 1, 1, 1}));
    }

    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            long prod = 1; // 当前子数组的乘积
            int curGCD = nums[i]; // 当前子数组的 GCD
            int curLCM = nums[i]; // 当前子数组的 LCM

            for (int j = i; j < n; j++) {
                prod *= nums[j];
                curGCD = gcd(curGCD, nums[j]);
                curLCM = lcm(curLCM, nums[j]);

                // 检查是否满足条件
                if (prod == (long) curGCD * curLCM) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    // 求两个数的 GCD
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 求两个数的 LCM（最小公倍数）
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    // 求整个数组的 GCD
    public static int findGCD(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = gcd(result, nums[i]);
            // 如果 GCD 已经是 1，提前结束
            if (result == 1) {
                break;
            }
        }
        return result;
    }


    // 求整个数组的 LCM
    public static int findLCM(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = lcm(result, nums[i]);
        }
        return result;
    }
}
