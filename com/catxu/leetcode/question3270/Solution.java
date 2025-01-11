package com.catxu.leetcode.question3270;

/**
 * 3270. Find the Key of the Numbers
 */
class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int ans = 0;
        for (int pow10 = 1; num1 > 0 && num2 > 0 && num3 > 0; pow10 *= 10) {
            ans += (Math.min(Math.min(num1 % 10, num2 % 10), num3 % 10)) * pow10;
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateKey(1, 10, 1000));
        System.out.println(new Solution().generateKey(987, 879, 798));
        System.out.println(new Solution().generateKey(1, 2, 3));
    }
}
