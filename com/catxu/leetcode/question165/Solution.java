package com.catxu.leetcode.question165;

/**
 * 165. Compare Version Numbers
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (int n = 0; n < Math.max(v1.length, v2.length); n++) {
            int i = (n < v1.length ? Integer.parseInt(v1[n]) : 0);
            int j = (n < v2.length ? Integer.parseInt(v2[n]) : 0);
            if (i < j) return -1;
            else if (i > j) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("1.2", "1.10"));
        System.out.println(new Solution().compareVersion("1.01", "1.001"));
        System.out.println(new Solution().compareVersion("1.0", "1.0.0.0"));
        System.out.println(new Solution().compareVersion("1.2", "1.1"));
    }
}
