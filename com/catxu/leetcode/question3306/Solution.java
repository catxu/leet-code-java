package com.catxu.leetcode.question3306;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 3306. Count of Substrings Containing Every Vowel and K Consonants II
 */
class Solution {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public long countOfSubstrings(String word, int k) {
        char[] s = word.toCharArray();
        return slidingWindow(s, k) - slidingWindow(s, k + 1);
    }

    private long slidingWindow(char[] s, int k) {
        Map<Character, Integer> vowels = new HashMap<>();
        long ans = 0;
        int left = 0, consonantCnt = 0;
        for (char c : s) {
            if (VOWELS.contains(c)) {
                vowels.merge(c, 1, Integer::sum);
            } else {
                consonantCnt++;
            }
            while (vowels.size() == 5 && consonantCnt >= k) {
                char del = s[left];
                if (VOWELS.contains(del)) {
                    if (vowels.merge(del, -1, Integer::sum) == 0) vowels.remove(del);
                } else {
                    consonantCnt--;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().countOfSubstrings("aeioqq", 1));
        System.out.println(new Solution().countOfSubstrings("aeioqqu", 1));
        System.out.println(new Solution().countOfSubstrings("ieaouqqieaouqq", 1));
    }
}
