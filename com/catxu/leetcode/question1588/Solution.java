package com.catxu.leetcode.question1588;

/**
 * 1588. Sum of All Odd Length Subarrays
 */
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length, sum = 0, len, l, r;
        int[] prefix = new int[n + 1];
        for (l = 1; l <= n; l++) {
            prefix[l] = arr[l - 1] + prefix[l - 1];
        }

        for (len = 1; len <= n; len += 2) {
            for (l = 0; (r = l + len - 1) < n; l++) {
                sum += prefix[r + 1] - prefix[l];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sumOddLengthSubarrays(new int[]{1, 2}));
    }
}
