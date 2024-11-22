package com.catxu.leetcode.question28;

/**
 * 28. Find the Index of the First Occurrence in a String
 * <p>
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "sadbutsad", needle = "sad"
 * <p>
 * Output: 0
 * <p>
 * Explanation: "sad" occurs at index 0 and 6.
 * <p>
 * The first occurrence is at index 0, so we return 0.
 * <p>
 * Example 2:
 * <p>
 * Input: haystack = "leetcode", needle = "leeto"
 * <p>
 * Output: -1
 * <p>
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * <p>
 * Constraints:
 * <p>
 * 1 <= haystack.length, needle.length <= 10<sup>4</sup>
 * <p>
 * haystack and needle consist of only lowercase English characters.
 */
class Solution {
    public int strStr(String haystack, String needle) {
        char[] source = haystack.toCharArray();
        int haystackLength = source.length;
        char[] target = needle.toCharArray();
        int needleLength = target.length;
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }
        return -1;
        //        return haystack.indexOf(needle);
    }
}
