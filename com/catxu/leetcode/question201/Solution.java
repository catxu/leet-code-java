package com.catxu.leetcode.question201;

/**
 * 201. Bitwise AND of Numbers Range
 * <p>
 * Constraints:
 * <pre>
 * 0 <= left <= right <= 2<sup>31</sup> - 1
 * </pre>
 */
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }

    public static void main(String[] args) {
        //  5     6     7
        // 101 & 110 & 111
        // 100
        System.out.println(new Solution().rangeBitwiseAnd(5, 7));
        System.out.println(new Solution().rangeBitwiseAnd(0, 0));
        System.out.println(new Solution().rangeBitwiseAnd(1, Integer.MAX_VALUE));
    }
}
