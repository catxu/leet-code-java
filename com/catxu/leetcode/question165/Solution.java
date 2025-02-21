package com.catxu.leetcode.question165;

/**
 * 165. Compare Version Numbers
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int m = v1.length, n = v2.length;
        int i = 0;
        for (; i < m; i++) {
            if (i >= n) {
                return -1;
            }
            int a = Integer.parseInt(v1[i]);
            int b = Integer.parseInt(v2[i]);
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
        }
        if (i < n) {

        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("1.01", "1.001"));
        System.out.println(new Solution().compareVersion("1.0", "1.0.0.0"));
    }
}
