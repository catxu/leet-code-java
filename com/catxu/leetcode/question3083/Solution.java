package com.catxu.leetcode.question3083;

import java.util.HashSet;
import java.util.Set;

/**
 * 3083. Existence of a Substring in a String and Its Reverse
 */
class Solution {
    public boolean isSubstringPresent(String s) {
        if (s.length() == 1) {
            return false;
        }
        Set<String> substrSet1 = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            String substr = chars[i] + "" + chars[i + 1];
            substrSet1.add(substr);
            if (i + 1 == chars.length - 1) {
                break;
            }
        }
        Set<String> substrSet2 = new HashSet<>();
        for (int i = chars.length - 1; i > 0; i--) {
            String substr = chars[i] + "" + chars[i - 1];
            substrSet2.add(substr);
            if (i - 1 == 0) {
                break;
            }
        }
        for (String substr : substrSet1) {
            if (substrSet2.contains(substr)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isSubstringPresent("leetcode"));
        System.out.println(s.isSubstringPresent("abcba"));
        System.out.println(s.isSubstringPresent("abcd"));
    }
}