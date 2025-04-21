package com.catxu.leetcode.question438;

import java.util.*;

/**
 * 438. Find All Anagrams in a String
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = p.length(), n = s.length();
        if (m > n) {
            return List.of();
        }
        Map<Character, Integer> dict = initDict(p, m);
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        char[] chs = s.toCharArray();
        int cnt = 0;
        for (int l = 0, i = 0; i < n; i++) {
            char cur = chs[i];
            window.merge(cur, 1, Integer::sum);
            if (dict.containsKey(cur)) {
                if (dict.get(cur).equals(window.get(cur))) {
                    cnt++;
                } else if (window.get(cur) - 1 == dict.get(cur)) { // 超过了字典中对应字符的个数
                    cnt--;
                }
            }
            if (i - l + 1 > m) { // 收缩左边界
                char remove = chs[l];
                window.merge(remove, -1, Integer::sum);
                if (dict.containsKey(remove) && window.get(remove) + 1 == dict.get(remove)) {
                    cnt--;
                } else if (dict.containsKey(remove) && window.get(remove).equals(dict.get(remove))) {
                    cnt++;
                }
//                if (window.get(remove) == 0) {
//                    window.remove(remove);
//                }
                l++;
            }
            if (cnt == dict.size()) {
                ans.add(l);
            }
        }
        return ans;
    }

    private Map<Character, Integer> initDict(String p, int m) {
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < m; i++) {
            dict.merge(p.charAt(i), 1, Integer::sum);
        }
        return dict;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new Solution().findAnagrams("abab", "ab"));
        System.out.println(new Solution().findAnagrams("b", "a"));
    }
}
