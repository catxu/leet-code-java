package com.catxu.leetcode.question49;

import java.util.*;

/**
 * 49. Group Anagrams
 * <p>
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * <p>
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * Explanation:
 * <p>
 * There is no string in strs that can be rearranged to form "bat".
 * <p>
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * <p>
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * <p>
 * Example 2:
 * <p>
 * Input: strs = [""]
 * <p>
 * Output: [[""]]
 * <p>
 * Example 3:
 * <p>
 * Input: strs = ["a"]
 * <p>
 * Output: [["a"]]
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 10<sup>4</sup>
 * <p>
 * 0 <= strs[i].length <= 100
 * <p>
 * strs[i] consists of lowercase English letters.
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());


        /*List<List<String>> ans = new ArrayList<>();
        List<String> dictionary = List.of(strs);
        Set<String> glossary = new HashSet<>();
        for (String str : strs) {
            if (glossary.contains(str)) {
                continue;
            }
            Set<String> fullRange = getFullRange(str);
            List<String> subSet = fullRange.stream().filter(dictionary::contains).toList();
            glossary.addAll(subSet);
            ans.add(new ArrayList<>(subSet));
        }
        return ans;*/
    }

    private Set<String> getFullRange(String str) {
        Set<String> res = new HashSet<>();
        List<String> state = new ArrayList<>();
        boolean[] used = new boolean[str.length()];
        // 先排序，便于后续避免重复
        Arrays.sort(str.toCharArray());
        backtrack(res, state, used, str);
        return res;
    }

    private void backtrack(Set<String> res, List<String> state, boolean[] used, String str) {
        if (state.size() == str.length()) {
            res.add(String.join("", state));  // 将当前排列加入结果集
            return;
        }
        // 先排序，以确保重复字符被排除
        for (int i = 0; i < str.length(); i++) {
            // 如果当前字符已经使用，跳过
            if (used[i]) continue;
            // 避免重复字符
            if (i > 0 && str.charAt(i) == str.charAt(i - 1) && !used[i - 1]) continue;
            // 做选择
            used[i] = true;
            state.add(String.valueOf(str.charAt(i)));
            // 回溯
            backtrack(res, state, used, str);
            // 撤销选择
            used[i] = false;
            state.removeLast();
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(s.groupAnagrams(new String[]{""}));
        System.out.println(s.groupAnagrams(new String[]{"a"}));
        System.out.println(s.groupAnagrams(new String[]{"", ""}));
        System.out.println(s.groupAnagrams(new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"}));
    }
}
