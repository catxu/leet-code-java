package com.catxu.leetcode.question3298;

/**
 * 3298. Count Substrings That Can Be Rearranged to Contain a String II
 */
class Solution {
    public long validSubstringCount(String word1, String word2) {
        if (word1.length() < word2.length()) {
            return 0;
        }
        int[] target = new int[26];
        int valid = 0;
        for (int i = 0; i < word2.length(); i++) {
            if (++target[word2.charAt(i) - 'a'] == 1) {
                valid++;
            }
        }
        int l = 0, r = 0;
        long ans = 0;
        int[] window = new int[26];
        while (r < word1.length()) {
            char c = word1.charAt(r);
            if (++window[c - 'a'] == target[c - 'a']) {
                valid--;
            }
            while (valid == 0) {
                char d = word1.charAt(l);
                if (--window[d - 'a'] < target[d - 'a']) {
                    valid++;
                }
                l++;
            }
            ans += l;
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validSubstringCount("dcbdcdccb", "cdd"));

        System.out.println(new Solution().validSubstringCount("bcca", "abc"));
        System.out.println(new Solution().validSubstringCount("abcabc", "abc"));
        System.out.println(new Solution().validSubstringCount("abcabc", "aaabc"));
    }

}
